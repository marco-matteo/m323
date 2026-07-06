import java.io.File

// readFileFromPath reads the data from the file under path.
// If no file exists the error is not thrown but returned as a Result.
fun readFileFromPath(path: String): Result<File> {
    return runCatching {
        val file = File(path)
        if (!file.exists()) return Result.failure(IllegalArgumentException("File not found: $path"))
        return Result.success(file)
    }
}

// writeFileIntoPath just writes the passed data form the parameter into
// whatever file is found in `path`. If a file's already there it's overwritten.
fun writeFileIntoPath(path: String, data: String): Result<Unit> {
    return runCatching { File(path).writeBytes(data.toByteArray()) }
}