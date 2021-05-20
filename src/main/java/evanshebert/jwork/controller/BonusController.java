package evanshebert.jwork.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import evanshebert.jwork.Bonus;
import evanshebert.jwork.DatabaseBonus;
import evanshebert.jwork.ReferralCodeAlreadyExistsException;

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
        return DatabaseBonus.getBonusByReferralCode(referralCode);
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
