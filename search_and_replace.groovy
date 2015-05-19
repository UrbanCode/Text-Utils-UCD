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

/*
final def filePath = './test.txt'
final def searchString = "E:\\Software\\IBM\\WebSphere\\AppServer\\profiles\\Myer\\installedApps\\WC_Myer_cell\\"
final def replacementString = "E:\\Software\\IBM\\HTTPServer\\htdocs\\"
*/

final def filePath = props['filePath']
final def searchString = props['searchString']
final def replacementString = props['replacementString']

println "Search string : $searchString"
println "Replacement string : $replacementString"

File file = new File(filePath)

println "Match(es) found: " + file.text.contains(searchString)

contents = file.text.replace(searchString, replacementString)
file.write(contents)

println "Search and replace performed"

System.exit(0)