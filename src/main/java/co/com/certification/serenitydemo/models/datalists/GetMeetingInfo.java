package co.com.certification.serenitydemo.models.datalists;

import co.com.certification.serenitydemo.models.MeetingDataModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetMeetingInfo {

    public List<MeetingDataModel> setData(DataTable dataTable) {
        List<MeetingDataModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, MeetingDataModel.class));
        }

        return dates;
    }
}
