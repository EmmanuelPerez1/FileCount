import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class Json {
    /**
     * Returns a single-line String JSON.
     *
     * @param storageDataArray an array of StorageData containing the
     *                         information to parse to JSON
     * @return String object representation of the StorageData array
     */
    public static String encode(StorageData[] storageDataArray) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{\"data\":");
        stringBuilder.append(new Gson().toJson(storageDataArray));
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    /**
     * Parses a stringified JSON String object to a StorageData array
     * @param json a stringified JSON String object
     * @return array of StorageData
     */
    public static StorageData[] decode(String json) {
        ArrayList<StorageData> arrayList = new ArrayList<>();
        JsonArray jsonArray = new JsonParser().parse(json)
                .getAsJsonObject().get("data").getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            arrayList.add(new StorageData(
                    jsonArray.get(i).getAsJsonObject().get("path").getAsString(),
                    jsonArray.get(i).getAsJsonObject().get("count").getAsInt()));
        }

        return arrayList.toArray(new StorageData[]{});
    }
}
