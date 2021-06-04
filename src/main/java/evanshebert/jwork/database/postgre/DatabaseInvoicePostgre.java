package evanshebert.jwork.database.postgre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import evanshebert.jwork.enums.InvoiceStatus;
import evanshebert.jwork.enums.JobCategory;
import evanshebert.jwork.enums.PaymentType;
import evanshebert.jwork.exceptions.InvoiceNotFoundException;
import evanshebert.jwork.exceptions.OngoingInvoiceAlreadyExistsException;
import evanshebert.jwork.objects.BankPayment;
import evanshebert.jwork.objects.Bonus;
import evanshebert.jwork.objects.EwalletPayment;
import evanshebert.jwork.objects.Invoice;
import evanshebert.jwork.objects.Job;
import evanshebert.jwork.objects.Jobseeker;
import evanshebert.jwork.objects.Location;
import evanshebert.jwork.objects.Recruiter;

/**
 * A list of database related to Postgre about Invoice
 *
 * @author Evans Hebert
 * @version 03 June 2021
 */
public class DatabaseInvoicePostgre {
    /**
     * Retrieve a list of invoice objects
     *
     * @return A list of invoice objects
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        // Get listInvoice
        return getData("");
    }

    /**
     * Retrieve the last ID of the database
     *
     * @return Last ID in Integer
     */
    public static int getInvoiceLastId() {
        int id = 0;
        try {
            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("SELECT MAX(id) FROM invoice");

            if (rs.next()) id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Retrieve a specified invoice that can be found by ID
     *
     * @return An invoice object
     */
    @SuppressWarnings("Duplicates")
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        try {
            Invoice invoice = null;
            ArrayList<Job> tempJob = new ArrayList<>();

            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("WITH job AS (" +
                            "SELECT j.id, j.name, j.recruiter_id, r.name as r_name, r.email, r.phoneNumber, r.province, r.city, r.description, j.fee, j.category " +
                            "FROM job j INNER JOIN recruiter r ON j.recruiter_id = r.id) " +
                            "SELECT i.id, i.job_id, j.name, j.recruiter_id, j.r_name, j.email, j.phoneNumber, j.province, j.city, j.description, j.fee, j.category, " +
                            "i.date, i.jobseeker_id, s.name, s.email, s.password, s.joinDate, i.invoiceStatus, i.paymentType, " +
                            "i.bonus_id, b.referralCode, b.extraFee, b.minTotalFee, b.active, i.adminFee " +
                            "FROM invoice i LEFT JOIN job j ON i.job_id = j.id LEFT JOIN jobseeker s ON i.jobseeker_id = s.id " +
                            "LEFT JOIN bonus b ON i.bonus_id = b.id WHERE i.id = " + id + " ORDER BY i.id, i.job_id");

            while (rs.next()) {
                if (invoice != null && rs.getInt(1) == id) {
                    Job job = new Job(
                            rs.getInt(2),
                            rs.getString(3),
                            new Recruiter(
                                    rs.getInt(4),
                                    rs.getString(5),
                                    rs.getString(6),
                                    rs.getString(7),
                                    new Location(
                                            rs.getString(8),
                                            rs.getString(9),
                                            rs.getString(10)
                                    )
                            ),
                            rs.getInt(11),
                            JobCategory.valueOf(rs.getString(12))
                    );
                    tempJob.add(job);
                    continue;
                }

                Calendar calendar = Calendar.getInstance();
                switch (PaymentType.get(rs.getString(20))) {
                    case BankPayment:
                        calendar.setTime(rs.getDate(18));
                        invoice = new BankPayment(
                                rs.getInt(1),
                                null,
                                new Jobseeker(
                                        rs.getInt(14),
                                        rs.getString(15),
                                        rs.getString(16),
                                        rs.getString(17),
                                        calendar
                                ),
                                rs.getInt(26)
                        );
                        calendar.setTime(rs.getDate(13));
                        invoice.setDate(calendar);
                        invoice.setInvoiceStatus(InvoiceStatus.valueOf(rs.getString(19)));
                        break;
                    case EwalletPayment:
                        calendar.setTime(rs.getDate(18));
                        invoice = new EwalletPayment(
                                rs.getInt(1),
                                null,
                                new Jobseeker(
                                        rs.getInt(14),
                                        rs.getString(15),
                                        rs.getString(16),
                                        rs.getString(17),
                                        calendar
                                )
                        );

                        if (rs.getInt(21) != 0) {
                            ((EwalletPayment) invoice).setBonus(
                                    new Bonus(
                                            rs.getInt(21),
                                            rs.getString(22),
                                            rs.getInt(23),
                                            rs.getInt(24),
                                            rs.getBoolean(25)
                                    )
                            );
                        }

                        calendar.setTime(rs.getDate(13));
                        invoice.setDate(calendar);
                        invoice.setInvoiceStatus(InvoiceStatus.valueOf(rs.getString(19)));
                        break;
                    default:
                        break;
                }

                Job job = new Job(
                        rs.getInt(2),
                        rs.getString(3),
                        new Recruiter(
                                rs.getInt(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                new Location(
                                        rs.getString(8),
                                        rs.getString(9),
                                        rs.getString(10)
                                )
                        ),
                        rs.getInt(11),
                        JobCategory.valueOf(rs.getString(12))
                );
                tempJob.add(job);
            }

            if (invoice != null) {
                invoice.setJobs(tempJob);
                return invoice;
            } else throw new InvoiceNotFoundException(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get a list of invoices that can be found by jobseeker's ID
     *
     * @param jobseekerId A jobseeker's ID
     * @return A list of invoice objects
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) {
        return getData("WHERE i.jobseeker_id = " + jobseekerId);
    }

    /**
     * Add a new invoice
     *
     * @param invoice An invoice Object
     * @return State to indicate an invoice has been successfully added
     */
    public static boolean insertInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        try {
            Connection c = DatabaseConnectionPostgre.connection();
            ResultSet rs = c.createStatement().executeQuery(
                    "SELECT jobseeker_id, invoicestatus from invoice where jobseeker_id = " +
                            invoice.getJobseeker().getId() + " AND invoicestatus = 'Ongoing'");

            if (rs.next()) throw new OngoingInvoiceAlreadyExistsException(invoice);

            Statement st = c.createStatement();
            for (Job job : invoice.getJobs()) {
                if (invoice instanceof BankPayment) {
                    st.executeUpdate("INSERT INTO invoice (id, job_id, date, totalfee, jobseeker_id, invoicestatus, paymenttype, adminfee) VALUES (" +
                            invoice.getId() + ", " + job.getId() + ", now(), " + invoice.getTotalFee() + ", " + invoice.getJobseeker().getId() + ", '" +
                            invoice.getInvoiceStatus() + "', '" + invoice.getPaymentType() + "', " + ((BankPayment) invoice).getAdminFee() + ")"
                    );
                } else if (invoice instanceof EwalletPayment) {
                    String bonus = "null";
                    if (((EwalletPayment) invoice).getBonus() != null) {
                        bonus = String.valueOf(((EwalletPayment) invoice).getBonus().getId());
                    }

                    st.executeUpdate("INSERT INTO invoice (id, job_id, date, totalfee, jobseeker_id, invoicestatus, paymenttype, bonus_id) VALUES (" +
                            invoice.getId() + ", " + job.getId() + ", now(), " + invoice.getTotalFee() + ", " + invoice.getJobseeker().getId() + ", '" +
                            invoice.getInvoiceStatus() + "', '" + invoice.getPaymentType() + "', " + bonus + ")"
                    );
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Change status of an invoice
     *
     * @param id            An invoice ID
     * @param invoiceStatus Status of the Invoice
     * @return State to indicate an invoice has been successfully changed
     */
    public static boolean updateInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        try {
            DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeUpdate("UPDATE invoice SET invoicestatus = '" + invoiceStatus.toString() + "' WHERE id = " + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Remove existing invoice by ID
     *
     * @param id An invoice's ID
     * @return State to indicate an invoice has been successfully removed
     */
    public static boolean deleteInvoice(int id) throws InvoiceNotFoundException {
        Invoice invoice = getInvoiceById(id);
        if (invoice != null) {
            try {
                DatabaseConnectionPostgre.connection()
                        .createStatement()
                        .executeUpdate("DELETE FROM invoice WHERE id = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else throw new InvoiceNotFoundException(id);
    }

    /**
     * Function to get a list of Invoice data
     *
     * @param query Where statement query to filter data.
     * @return A list of invoice data
     */
    @SuppressWarnings("Duplicates")
    private static ArrayList<Invoice> getData(String query) {
        ArrayList<Invoice> list = new ArrayList<>();

        try {
            Invoice tempInvoice = null;
            ArrayList<Job> tempJob = new ArrayList<>();

            ResultSet rs = DatabaseConnectionPostgre.connection()
                    .createStatement()
                    .executeQuery("WITH job AS (" +
                            "SELECT j.id, j.name, j.recruiter_id, r.name as r_name, r.email, r.phoneNumber, r.province, r.city, r.description, j.fee, j.category " +
                            "FROM job j INNER JOIN recruiter r ON j.recruiter_id = r.id) " +
                            // SELECT GOES HERE
                            "SELECT i.id, i.job_id, j.name, j.recruiter_id, j.r_name, j.email, j.phoneNumber, j.province, j.city, j.description, j.fee, j.category, " +
                            "i.date, i.jobseeker_id, s.name, s.email, s.password, s.joinDate, i.invoiceStatus, i.paymentType, " +
                            "i.bonus_id, b.referralCode, b.extraFee, b.minTotalFee, b.active, i.adminFee " +
                            "FROM invoice i LEFT JOIN job j ON i.job_id = j.id LEFT JOIN jobseeker s ON i.jobseeker_id = s.id " +
                            "LEFT JOIN bonus b ON i.bonus_id = b.id " + query + " ORDER BY i.id, i.job_id");

            while (rs.next()) {
                if (tempInvoice != null) {
                    if (tempInvoice.getId() == rs.getInt(1)) {
                        Job job = new Job(
                                rs.getInt(2),
                                rs.getString(3),
                                new Recruiter(
                                        rs.getInt(4),
                                        rs.getString(5),
                                        rs.getString(6),
                                        rs.getString(7),
                                        new Location(
                                                rs.getString(8),
                                                rs.getString(9),
                                                rs.getString(10)
                                        )
                                ),
                                rs.getInt(11),
                                JobCategory.valueOf(rs.getString(12))
                        );
                        tempJob.add(job);
                        continue;
                    } else {
                        tempInvoice.setJobs(tempJob);
                        tempInvoice.setTotalFee();
                        list.add(tempInvoice);
                        tempInvoice = null;
                        tempJob = new ArrayList<>();
                    }
                }

                Calendar calendar = Calendar.getInstance();
                switch (PaymentType.get(rs.getString(20))) {
                    case BankPayment:
                        calendar.setTime(rs.getDate(18));
                        tempInvoice = new BankPayment(
                                rs.getInt(1),
                                null,
                                new Jobseeker(
                                        rs.getInt(14),
                                        rs.getString(15),
                                        rs.getString(16),
                                        rs.getString(17),
                                        calendar
                                ),
                                rs.getInt(26)
                        );
                        calendar.setTime(rs.getDate(13));
                        tempInvoice.setDate(calendar);
                        tempInvoice.setInvoiceStatus(InvoiceStatus.valueOf(rs.getString(19)));
                        break;
                    case EwalletPayment:
                        calendar.setTime(rs.getDate(18));
                        tempInvoice = new EwalletPayment(
                                rs.getInt(1),
                                null,
                                new Jobseeker(
                                        rs.getInt(14),
                                        rs.getString(15),
                                        rs.getString(16),
                                        rs.getString(17),
                                        calendar
                                )
                        );

                        if (rs.getInt(21) != 0) {
                            ((EwalletPayment) tempInvoice).setBonus(
                                    new Bonus(
                                            rs.getInt(21),
                                            rs.getString(22),
                                            rs.getInt(23),
                                            rs.getInt(24),
                                            rs.getBoolean(25)
                                    )
                            );
                        }

                        calendar.setTime(rs.getDate(13));
                        tempInvoice.setDate(calendar);
                        tempInvoice.setInvoiceStatus(InvoiceStatus.valueOf(rs.getString(19)));

                        break;
                    default:
                        break;
                }

                Job job = new Job(
                        rs.getInt(2),
                        rs.getString(3),
                        new Recruiter(
                                rs.getInt(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                new Location(
                                        rs.getString(8),
                                        rs.getString(9),
                                        rs.getString(10)
                                )
                        ),
                        rs.getInt(11),
                        JobCategory.valueOf(rs.getString(12))
                );
                tempJob.add(job);
            }

            if (tempInvoice != null) {
                tempInvoice.setJobs(tempJob);
                tempInvoice.setTotalFee();
                list.add(tempInvoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
