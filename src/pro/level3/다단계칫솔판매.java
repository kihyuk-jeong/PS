package pro.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {

    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] answer = solution(enroll, referral, seller, amount);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        Map<String, String> map = new HashMap<>();

        int length = enroll.length;

        // 피추천인과 추천인 셋팅
        for (int i = 0; i < length; i++) {
            map.put(enroll[i], referral[i]);
        }

        int sellerLength = seller.length;

        Map<String, Integer> sellerMap = new HashMap<>();

        for (int i = 0; i < sellerLength; i++) {
            String sellerKey = seller[i];
            int sellerAmount = amount[i] * 100;

            while (sellerAmount > 0 && !sellerKey.equals("-")) {
                sellerMap.put(sellerKey, sellerMap.getOrDefault(sellerKey, 0) + sellerAmount - (sellerAmount / 10));

                sellerKey = map.get(sellerKey);
                sellerAmount /= 10;
            }
        }

        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = sellerMap.getOrDefault(enroll[i], 0);
        }

        return answer;


    }


}
