package commands

object Commands {
    // https://falcosuessgott.github.io/golang-cli-template/
    fun version() {
        println("MDtoHTML v0.0.1")
    }

    fun convert(args: List<String>): Result<Unit> {
        if (args.size == 2) {
            return parse(args[0], args[1], null)
        } else if (args.size == 3) {
            return parse(args[0], args[1], args[2])
        }
        return Result.failure(IllegalArgumentException("Expected 3 arguments: <input> <output> (<css-file>)"))
    }
}