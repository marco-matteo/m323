fun main(args: Array<String>) {
    val cli = Cli()

    try {
        cli.run(args)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
        println()
        cli.printHelp()
    } catch (e: Exception) {
        println("Unexpected error: ${e.message}")
    }
}