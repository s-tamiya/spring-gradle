package hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import hello.dto.HelloDto;

@Service
public class HelloService {
    /**
     * 与えられた数値からfizzbuzz結果リストを作成する。
     *
     * @param n 数値
     * @return fizzbuzz結果リスト
     */
    public List<HelloDto> numToFizzbuzzList(int num) {
        List<HelloDto> helloDtoList = new ArrayList<HelloDto>();

        for (int i = 1; i < num; i++) {
            HelloDto helloDto = new HelloDto();
            helloDto.setFontSize(randomFontSize());
            helloDto.setWord(fizzbuzz(i));
            helloDtoList.add(helloDto);
        }
        return helloDtoList;
    }

    /**
     * 与えられた数値のfizzbuzz結果を返却する。
     * Hello!, World!, HelloWorld!! のいずれかを返却する。
     *
     * @param num 数値
     * @return fizzbuzz 結果
     */
    private String fizzbuzz(int num) {
        if (num % 15 == 0) {
            return "HelloWorld!!";
        }else if (num % 3 == 0){
            return "Hello!";
        }else if (num % 5 == 0){
            return "World!";
        }else {
            return num + "!";
        }
    }

    /**
     * 10～100のランダムな数値を返却する
     *
     * @return ランダムな数値
     */
    private int randomFontSize() {
        Random random = new Random();
        return ((random.nextInt(10) * 10) + 10);
    }
}
