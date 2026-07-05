package commands

object Commands {
    fun version() {
        println("MDtoHTML v0.0.1")
    }

    fun convert(args: List<String>): String {
        if (args.size != 2) {
            return "no"
//            return Result.failure("Error: Incorrect usage. Please check help page.")
        }
         parse(args[0], args[1])
        return "yes"
    }
}