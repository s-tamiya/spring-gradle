package hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import hello.dto.HelloDto;

@Service
public class HelloService {
    /**
     * �^����ꂽ���l����fizzbuzz���ʃ��X�g���쐬����B
     *
     * @param n ���l
     * @return fizzbuzz���ʃ��X�g
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
     * �^����ꂽ���l��fizzbuzz���ʂ�ԋp����B
     * Hello!, World!, HelloWorld!! �̂����ꂩ��ԋp����B
     *
     * @param num ���l
     * @return fizzbuzz ����
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
     * 10�`100�̃����_���Ȑ��l��ԋp����
     *
     * @return �����_���Ȑ��l
     */
    private int randomFontSize() {
        Random random = new Random();
        return ((random.nextInt(10) * 10) + 10);
    }
}
