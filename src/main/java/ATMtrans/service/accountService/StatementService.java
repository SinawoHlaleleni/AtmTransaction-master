package ATMtrans.service.accountService;

import ATMtrans.domain.account.Statement;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface StatementService extends IService <Statement,String> {
    Set<Statement> getAll();
}