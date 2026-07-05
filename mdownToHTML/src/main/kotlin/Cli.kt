import commands.Commands

class Cli {
    fun run(args: Array<String>) {
        if (args.isEmpty()) {
            printHelp()
            return
        }

        when (args[0]) {
            "convert" -> Commands.convert(args.drop(1))
            "version" -> Commands.version()
            "help" -> printHelp()
            else -> throw IllegalArgumentException("Unknown command: ${args[0]}")
        }
    }

    fun printHelp() {
        println(
            """
            MDtoHTML

            Usage:
              MDtoHTML <command> [options]

            Commands:
              convert <markdownPath> <targetPath>   Convert Markdown into HTMLFile
              help                                  Show this help
            """.trimIndent()
        )
    }
}