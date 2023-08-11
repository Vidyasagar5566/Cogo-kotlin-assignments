fun main() {
    var holder1 = BankAccount("38577686705","Srinivas",5000.00)
    var holder2 = BankAccount("85776863705","Vidya Sagar",4500.00)

    holder1.Deposite(100.0)
    holder1.GetBalance()
    println("")
    holder1.Withdraw(6000.0)
    holder1.GetBalance()
    println("")
    holder1.Withdraw(4000.0)
    holder1.GetBalance()


    println("")
    println("")

    holder2.Deposite(1000.0)
    holder2.GetBalance()
    println("")
    holder2.Withdraw(7000.0)
    holder2.GetBalance()
    println("")
    holder2.Withdraw(4000.0)
    holder2.GetBalance()
    println("")

}


class BankAccount(
    private var AccountNumber: String = "",
    private var AccountHolderName: String = "",
    private var Balance :Double = 0.0
){



    fun Deposite(amount: Double = 0.0){
        if (amount == 0.0){
            println("Amount can't be zero!!")
        }
        else{
            Balance += amount
            println("$amount successfully deposited into your account number $AccountNumber")
        }
    }

    fun Withdraw(amount: Double = 0.0){
        if (amount == 0.0){
            println("Amount can't be zero!!")
        }
        else{
            if (amount <= Balance) {
                Balance -= amount
                println("$amount successfully withdraw from your account number $AccountNumber")
            }
            else{
                println("Insufficient funds!!")
            }
        }
    }

    fun GetBalance (){
        println("Hello Mr/Ms $AccountHolderName, welcome to our bank")
        println("Your account  number is : $AccountNumber")
        println("Your current balance is : $Balance")

    }

}