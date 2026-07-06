package commands

object Commands {
    fun version() {
        println("MDtoHTML v0.0.1")
    }

    fun convert(args: List<String>): Result<Unit> {
        if (args.size != 2) {
            return Result.failure(IllegalArgumentException("Expected 2 arguments: <input> <output>"))
        }
         return parse(args[0], args[1])
    }
}