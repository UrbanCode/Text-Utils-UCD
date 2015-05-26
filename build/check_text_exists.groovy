/*
final def workDir = new File('.').canonicalFile
final def props = new Properties()
final def inputPropsFile = new File(args[0])
try {
    inputPropsStream = new FileInputStream(inputPropsFile)
    props.load(inputPropsStream)
}
catch (IOException e) {
    throw new RuntimeException(e)
}
*/


final def folderPath = 'C:/test/'

/*

final def folderPath = props['folderPath']
final def searchString = props['searchString']

println "Checking file ${folderPath} for searching string : ${searchString}"

File file = new File(folderPath)

if (!file.exists()) {
	println "File does not exist"
	System.exit(-1)
}

if (file.text.contains(searchString)) {
	println "Match found"
} else {
	println "Match not found"
	System.exit(-1)
}

System.exit(0)