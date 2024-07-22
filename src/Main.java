import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String temp = "_gf=A; _fbp=fb.1.1721193120645.835458394315095534; _fwb=240CZ5Wr20gKgB6MlQW12Pz.1721193120654; _gcl_au=1.1.1423271640.1721193120; _hjSessionUser_1491926=eyJpZCI6IjkzYzM1MTQ3LWFjZjYtNTJhNC1iZjk0LTU1ZGIwN2ZlODg5MCIsImNyZWF0ZWQiOjE3MjExOTMxMjA2MDIsImV4aXN0aW5nIjp0cnVlfQ==; tr[pv]=18; _hjSession_1491926=eyJpZCI6ImQ0YTY4Mjc2LWQwYjctNDVjYy05ZmE1LWJlZTFlZGU0Y2JiMCIsImMiOjE3MjE2Mjc5NDA1NzIsInMiOjAsInIiOjAsInNiIjowLCJzciI6MCwic2UiOjAsImZzIjowLCJzcCI6MH0=; mss_service=M; tr[vc]=3; tr[vt]=1721632483; mss-log-cookieId=88ccdf7d5525054d; lastSelectedFilter=category; PHPSESSID=9ad2dda9328eb06e6b3061aee7875929; tr[vd]=1721629726; tr[vid]=669dfc1e4a3737.48432354; AMP_20b47a4676=JTdCJTIyZGV2aWNlSWQlMjIlM0ElMjIzZDI2NjEwNi1iYjZiLTQ1YzUtYjE4MC05ZGNjMjg0ZjcyMmIlMjIlMkMlMjJzZXNzaW9uSWQlMjIlM0ExNzIxNjI3OTM2MTI4JTJDJTIyb3B0T3V0JTIyJTNBZmFsc2UlMkMlMjJsYXN0RXZlbnRUaW1lJTIyJTNBMTcyMTYyOTcyNTE4OCUyQyUyMmxhc3RFdmVudElkJTIyJTNBMTIlN0Q=; cart_no=%2FNWnG%2FI0Y%2FjNkl1smALbXelXkww11EnlovYkIPKneIgaDsezqAA9WiA4NwFp1gVE; SCOUTER=x7t8q602ihk726; ak=65D5323C-B124-498B-A7B4-296F6FF79B7B; app_key=65D5323C-B124-498B-A7B4-296F6FF79B7B; device=app; device_kind=ios; dvm=";

        String[] split = temp.split(";");

        System.out.println(split.length);


        System.out.println(Arrays.toString(split));

        for (String s : split) {
            System.out.println(s);
        }


//        String f = "_gf=A; _fbp=fb.1.1721193120645.835458394315095534;";
//
//        String[] split1 = f.split(";");
//
//        for (String ff : split1) {
//            System.out.println(ff);
//        }
//
//        System.out.println(split1.length);
//
//        System.out.println(Arrays.toString(split1));

    }
}