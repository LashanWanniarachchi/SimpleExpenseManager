package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import android.content.Context;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentTransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;

/**
 * Created by Lashan on 11/19/2017.
 */

public class PersistentExpenseManager extends ExpenseManager {
    Context ctx;

    public PersistentExpenseManager(Context c) {
        ctx = c;
        setup();
    }

    @Override
    public void setup() {
        /*** Begin generating dummy data for In-Memory implementation ***/

        TransactionDAO inMemoryTransactionDAO = new PersistentTransactionDAO(ctx);
        setTransactionsDAO(inMemoryTransactionDAO);

        AccountDAO inMemoryAccountDAO = new PersistentAccountDAO(ctx);
        setAccountsDAO(inMemoryAccountDAO);

        // dummy data
        Account dummyAcct1 = new Account("12345A", "Yoda Bank", "Anakin Skywalker", 10000.0);
        Account dummyAcct2 = new Account("78945Z", "Clone BC", "Obi-Wan Kenobi", 80000.0);
        getAccountsDAO().addAccount(dummyAcct1);
        getAccountsDAO().addAccount(dummyAcct2);

        /*** End ***/
    }
}
