import org.testng.annotations.DataProvider;
public class ReceptionOfDocsTestData {
    @DataProvider(name="testdata")
    public Object[][]dataSet(){
        return new Object[][]
                {
                        {"????? ?? ??????????",100,"?????? ?? ????????","?????? ??????????? ???? ?? ?????????????","??????? ???????? ????????","???????? ?????????"},
                        {"????? ?? ??????????",250,"?????? ???????","????? ?? ?????? ???????? ??????????","??????? ???????? ????????","???????? ?????????"},
                        {"????? ?? ??????????",3000,"????????????? ??????????? ????? ?????? ?? ????????","????????? ?????","??????? ???????? ????????","???????? ?????????"},
                        {"????? ?? ??????????",40,"?????? ??????","????? ?? ??????? ??????","??????? ???????? ????????","???????? ?????????"},
                };
    }
}
