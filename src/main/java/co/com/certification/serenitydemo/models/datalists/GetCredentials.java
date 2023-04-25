package co.com.certification.serenitydemo.models.datalists;

import co.com.certification.serenitydemo.models.CredentialsModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetCredentials {

    public List<CredentialsModel> setCredentials(DataTable dataTable) {
        List<CredentialsModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, CredentialsModel.class));
        }

        return dates;
    }
}
