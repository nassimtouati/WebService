package com.WebService.tn.testUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.WebService.tn.controller.AccueilController;
import com.WebService.tn.database.model.Groupes;
import com.WebService.tn.database.model.Users;

@RunWith(Suite.class)
@SuiteClasses({
                Users.class,
                AccueilController.class })
public class AllTests {

}
