import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class Json {
    public static String encode(StorageData[] storageDataArray) {
        ArrayList<StorageData> storageDataList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (StorageData storageData : storageDataArray)
            storageDataList.add(storageData);

        stringBuilder.append("{\"data\":");
        stringBuilder.append(new Gson().toJson(storageDataList));
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

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
