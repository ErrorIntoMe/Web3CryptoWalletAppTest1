package BankAccount

open class BankAccount(
    private var balance: Int = 0,

    ) {
    fun deposit(amount: Int) {
        if (amount > 0){
            balance += amount
        }
    }

    protected fun withdraw(amount: Int){
        if (amount > 0 && balance > amount){
            balance -= amount
        }
        else println("Бабок нет")
    }

    fun getBalance(): Int {
        return balance
    }
}