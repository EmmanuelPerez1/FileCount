public class SizeFiles {
    public static void main(String[] args) {
        String[] paths = new String[]{
                "\\\\172.18.48.230\\nice_sc\\niceapps1din\\48",
                "\\\\172.18.104.119\\Amex\\niceapps1sev\\46"};
        StorageData[] sdArray = StorageData.get(paths),
                sdArray1;
        String result = Json.encode(sdArray);

        System.out.println(result);
        sdArray1 = Json.decode(result);

        System.out.println(sdArray1.toString());
    }
}
