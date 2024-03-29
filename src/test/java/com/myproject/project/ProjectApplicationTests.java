package com.myproject.project;

import com.alibaba.fastjson.JSONObject;
import com.myproject.project.model.HotListDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectApplicationTests {

    @Test
    void contextLoads() {
        String json = "{hotList: [\n" +
                "      {\n" +
                "        coverImg: 'http://i2.hdslb.com/bfs/archive/1239539a2f262d933bca7c2c1e290139420ba76a.jpg_320x200.jpg',\n" +
                "        title: '【乐正绫】《华夏之章》【小旭PRO】【绛舞乱丸】',\n" +
                "        playNum: '4.7万',\n" +
                "        commentNum: '977',\n" +
                "        avid: 'av1'\n" +
                "      },\n" +
                "      {\n" +
                "        coverImg: 'http://i1.hdslb.com/bfs/archive/ecce95b426faf188e6c28f9d3a0bdc63c5a72bb3.jpg_320x200.jpg',\n" +
                "        title: '【斗图歌】test不如斗图',\n" +
                "        playNum: '4.7万',\n" +
                "        commentNum: '977',\n" +
                "        avid: 'av2'\n" +
                "      },\n" +
                "      {\n" +
                "        coverImg: 'http://i0.hdslb.com/bfs/archive/11bf8d41fffcad31976317760e301e2db64be8c8.png_320x200.png',\n" +
                "        title: '【胖胖球】【双子星】【獒龙】荒岛 - El transcurrir de las horas',\n" +
                "        playNum: '4.7万',\n" +
                "        commentNum: '977',\n" +
                "        avid: 'av3'\n" +
                "      },\n" +
                "      {\n" +
                "        coverImg: 'http://i0.hdslb.com/bfs/archive/e73a92b0ed615b4d6568888906d09f84d0835674.jpg_320x200.jpg',\n" +
                "        title: '撩人净土系列【红菱歌舞伎初音】极乐净土【大神犬PV付】MME配布',\n" +
                "        playNum: '4.7万',\n" +
                "        commentNum: '977',\n" +
                "        avid: 'av4'\n" +
                "      }\n" +
                "    ]}";

        List list = JSONObject.parseObject(json, List.class);
        System.out.println("list = " + list);
    }

}
