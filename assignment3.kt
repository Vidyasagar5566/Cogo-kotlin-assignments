fun main() {
    var students_names = mutableListOf<String>("srinivas","vidya sagar","sai vardhan","srikhar","tejesh","gopal","jai","harshitha","bhavya sri","harika")
    var students_id = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10)
    var student_age = mutableListOf<Int>(21,22,20,19,25,20,22,20,19,18)
    var student_marks = mutableListOf<Double>(90.0,75.0,30.0,39.0,88.0,45.0,69.0,91.0,95.0,90.0)

    var students = mutableListOf<Student>()

    for (i in 0..9){
        var a = Student(students_id[i],students_names[i],student_age[i],student_marks[i])
        students.add(a)
    }


    fun filterPassedStudents () {
        var passStudents = students.filter { it.marks >= 40 }
        //As we're getting classes we need to convert into names
        val passstudents = passStudents.map { it.name }
        println("pass students are : $passstudents")
    }

    fun findAverageAge(){
        val totalAge = students.map { it.age }.sum()
        println("Average Age of all the students is :  ${totalAge / students.size.toDouble()}")
    }

    fun findTopScore() {
        println("Top score out of all the students is : ${students.maxByOrNull { it.marks }?.name}")
    }

    filterPassedStudents()
    findAverageAge()
    findTopScore()


}

class Student(
    var id:Int = 0,
    var name :String = "",
    var age:Int = 0,
    var marks:Double = 0.0
)



