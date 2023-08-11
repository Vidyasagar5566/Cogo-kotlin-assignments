fun main() {
    val savingsAccount = SavingsAccount("38577686705","Srinivas",5000.00, 0.02)
    val checkingAccount = CheckingAccount("85776863705","Vidya Sagar",4000.00, 1000.0)

    savingsAccount.Deposit(300.0)
    savingsAccount.GetBalance()
    println("")
    savingsAccount.Withdraw(4300.0)
    savingsAccount.GetBalance()
    println("")
    savingsAccount.Withdraw(300.0)
    savingsAccount.GetBalance()


    println("")
    println("")

    checkingAccount.Deposit(500.0)
    checkingAccount.GetBalance()
    println("")
    checkingAccount.Withdraw(500.0)
    checkingAccount.GetBalance()
    println("")
    checkingAccount.Withdraw(4500.0)
    checkingAccount.GetBalance()
    println("")

}

interface bankAccount {
    fun Deposit(amount: Double)
    fun Withdraw(amount: Double)
    fun GetBalance()
}

class SavingsAccount(
    private val AccountNumber: String = "",
    private val AccountHolderName: String = "",
    private var Balance: Double = 0.0,
    private val InterestRate: Double = 0.0
) : bankAccount {

    override fun Deposit(amount: Double) {
        if (amount == 0.0){
            println("Amount can't be zero!!")
        }
        else{
            Balance += amount
            println("$amount successfully deposited into your account number $AccountNumber")
        }

    }

    override fun Withdraw(amount: Double) {
        if (Balance - amount >= 1000) {
            Balance -= amount
            println("$amount successfully withdraw from your account number $AccountNumber")

        } else if (Balance >= amount + (amount * InterestRate)) {
            // decreasing balance including Intrest
            Balance -= (amount + (amount * 0.02))
            println("$amount successfully withdraw from your account number $AccountNumber with intrest of 0.02")
        } else {
            println("Insufficient funds!!")
        }
    }

    override fun GetBalance() {
        println("Hello Mr/Ms $AccountHolderName, welcome to our bank")
        println("Your account  number is : $AccountNumber")
        println("Your current balance is : $Balance")
    }
}


class CheckingAccount(
    private val AccountNumber: String,
    private val AccountHolderName: String,
    private var Balance: Double,
    private val OverdraftLimit: Double
) : bankAccount {

    override fun Deposit(amount: Double) {
        if (amount == 0.0){
            println("Amount can't be null!!")
        }
        else{
            Balance += amount
            println("$amount successfully deposited into your account number $AccountNumber")
        }
    }

    override fun Withdraw(amount: Double) {
        if (amount == 0.0){
            println("Amount can't be null!!")
        }

        if (Balance - amount >= -OverdraftLimit) {
            if (Balance < amount) {
                Balance -= (amount + 50)
                println("$amount successfully withdraw from your account number $AccountNumber with an intrest of 50 rupees")
            } else {
                Balance -= amount
                println("$amount successfully withdraw from your account number $AccountNumber")
            }

        } else {
            println("OverdraftLimit has been reached!, you cannot withdraw amount from your account!!")
        }
    }

    override fun GetBalance() {
        println("Hello Mr/Ms $AccountHolderName, welcome to our bank")
        println("Your account  number is : $AccountNumber")
        println("Your current balance is : $Balance")
    }
}


