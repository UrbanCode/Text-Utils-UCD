import org.json.XML;
import org.json.JSONObject;

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

final def xmlFilePath = props['xmlFilePath']
final def jsonFilePath = props['jsonFilePath']

File file = new File(xmlFilePath)

if (!file.exists()) {
    println "File does not exist"
    System.exit(-1)
}

def JSONObject xmlJSONObj = XML.toJSONObject(file.text);
String jsonText = xmlJSONObj.toString(4);

File jsonFile = new File(jsonFilePath)
jsonFile.write(jsonText);

println "XML file " + xmlFilePath " successfully converted to JSON file " jsonFilePath

System.exit(0)