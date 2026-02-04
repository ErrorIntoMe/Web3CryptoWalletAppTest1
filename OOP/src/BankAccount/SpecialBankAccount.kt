package BankAccount

class SpecialBankAccount(
    balance: Int
): BankAccount(balance = balance) {

    fun specialWithdraw(amount: Int){
        withdraw(amount)
    }
}