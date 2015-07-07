final def workDir = new File('.').canonicalFile
final def props = new Properties()
final def inputPropsFile = new File(args[0])
try {
    inputPropsStream = new FileInputStream(inputPropsFile);
    props.load(inputPropsStream);
}
catch (IOException e) {
    throw new RuntimeException(e)
}

/*
final def filePath = 'C:/test/test.txt'
final def searchString = '\\<\\!\\-\\-\\s+<requestHandler name=\"/replication\" class=\"solr.ReplicationHandler\">\\s+<lst name=\"master\">\\s+<str name=\"replicateAfter\">commit</str>\\s+<str name=\"replicateAfter\">startup</str>\\s+<str name=\"confFiles\">schema.xml,stopwords.txt</str>\\s+</lst>\\s+</requestHandler>\\s+-->'
final def replacementString = "xml"
*/

final def filePath = props['filePath']
final def searchString = props['searchString']
final def replacementString = props['replacementString']

println "Search string : $searchString"
println "Replacement string : $replacementString"

File file = new File(filePath)

def matcher = file.text =~ /$searchString/
println "Number of match(es) found: " + matcher.getCount()
println "Matched the following lines:"
file.text.findAll(/$searchString/).each { match -> println "$match" }

contents = file.text.replaceAll(searchString, replacementString)
file.write(contents)

println "Search and replace performed"

System.exit(0)
