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

@RequestMapping("/bonus")
@RestController
public class BonusController
{

    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus()
    {
        return DatabaseBonus.getBonusDatabase();
    }

    @RequestMapping("/{referralCode}")
    public Bonus getBonusByReferralCode(@PathVariable String referralCode)
    {
        try {
            return DatabaseBonus.getBonusByReferralCode(referralCode);
        } catch (BonusNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value = "referralCode") String referralCode,
                          @RequestParam(value = "extraFee") int extraFee,
                          @RequestParam(value = "minTotalFee") int minTotalFee,
                          @RequestParam(value = "active") boolean active)
    {
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
