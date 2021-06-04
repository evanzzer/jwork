package evanshebert.jwork.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import evanshebert.jwork.exceptions.BonusNotFoundException;
import evanshebert.jwork.objects.Bonus;
import evanshebert.jwork.database.DatabaseBonus;
import evanshebert.jwork.exceptions.ReferralCodeAlreadyExistsException;

/**
 * Bonus Controller for Bonus Related API
 *
 * @author Evans Hebert
 * @version 04 June 2021
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {
    /**
     * Get All Bonus from Database
     *
     * @return List of Bonus
     */
    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus() {
        return DatabaseBonus.getBonusDatabase();
    }

    /**
     * Get Bonus by using the referral code
     *
     * @param referralCode Bonus Referral Code
     * @return List of Recruiter
     */
    @RequestMapping("/{referralCode}")
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        try {
            return DatabaseBonus.getBonusByReferralCode(referralCode);
        } catch (BonusNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    /**
     * Add a new Bonus
     *
     * @param referralCode Bonus COde
     * @param extraFee     Bonus Extra Fee to be applied
     * @param minTotalFee  Minimal total fee needed for the bonus to apply
     * @param active       Bonus status
     * @return A new created bonus object
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value = "referralCode") String referralCode,
                          @RequestParam(value = "extraFee") int extraFee,
                          @RequestParam(value = "minTotalFee") int minTotalFee,
                          @RequestParam(value = "active") boolean active) {
        try {
            Bonus bonus = new Bonus(
                    DatabaseBonus.getLastId() + 1,
                    referralCode,
                    extraFee,
                    minTotalFee,
                    active
            );
            boolean status = DatabaseBonus.addBonus(bonus);
            return status ? bonus : null;
        } catch (ReferralCodeAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
    }
}
