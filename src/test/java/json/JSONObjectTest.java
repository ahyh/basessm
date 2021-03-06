package json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JSONObjectTest {

    private static final String SENSITIVE_MARK = "sensitive";

    private static final String SENSITIVE_WORD_TYPE = "wordType";

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("测试", "动词");
        map.put("热词", "名词");
    }

    @Test
    public void testJsonObject() throws Exception {
        String s = "{\"segId\":0,\"bg\":380,\"ed\":2200,\"ei\":0,\"ls\":false,\"metadata\":\"\",\"msgtype\":\"sentence\",\"sn\":1,\"pa\":0,\"vad\":{\"ws\":[{\"bg\":38,\"ed\":220}]},\"ws\":[{\"bg\":0,\"cw\":[{\"sc\":\"0.00\",\"sf\":0,\"w\":\"测试\",\"wb\":0,\"wc\":\"1.00\",\"we\":0,\"wp\":\"n\"}]},{\"bg\":0,\"cw\":[{\"sc\":\"0.00\",\"sf\":0,\"w\":\"一下\",\"wb\":0,\"wc\":\"1.00\",\"we\":0,\"wp\":\"n\"}]},{\"bg\":0,\"cw\":[{\"sc\":\"0.00\",\"sf\":0,\"w\":\"热词\",\"wb\":0,\"wc\":\"1.00\",\"we\":0,\"wp\":\"n\"}]},{\"bg\":0,\"cw\":[{\"sc\":\"0.00\",\"sf\":0,\"w\":\"。\",\"wb\":0,\"wc\":\"0.00\",\"we\":0,\"wp\":\"p\"}]}],\"speakerItem\":{\"socre\":0.0,\"value\":\"\"}}";
        JSONObject obj = (JSONObject) JSONObject.parse(s);
        JSONArray ja = (JSONArray) obj.get("ws");
        ja.forEach(an -> {
            JSONObject temp = (JSONObject) an;
            JSONArray tempJsonArray = (JSONArray) temp.get("cw");
            tempJsonArray.forEach(tan -> {
                JSONObject ttemp = (JSONObject) tan;
                String word = (String) ttemp.get("w");
                if (map.containsKey(word)) {
                    ttemp.put(SENSITIVE_MARK, 1);
                    ttemp.put(SENSITIVE_WORD_TYPE, map.get(word));
                }
            });
        });
        System.out.println(obj.toString());
        System.out.println(obj);
    }

    @Test
    public void testJsonArray() throws Exception {
        String s = "{\"result\":[{\"label\":\"datetime2\",\"score\":\"1.000000\",\"result\":{\"org_text\":\"欢迎来到安徽合肥，今天这里的天气很好\",\"org_wildchar\":\"####----#--#######\",\"score\":\"0.000000\",\"key\":[{\"mean\":\"+datetime2\",\"text\":\"今天\",\"wildchar\":\"--\",\"begin\":\"9\",\"end\":\"11\",\"score\":\"0.101562\"}]}},{\"label\":\"place\",\"score\":\"1.000000\",\"result\":{\"org_text\":\"欢迎来到安徽合肥，今天这里的天气很好\",\"org_wildchar\":\"####----#--#######\",\"score\":\"0.000000\",\"key\":[{\"mean\":\"+place\",\"text\":\"安徽合肥\",\"wildchar\":\"----\",\"begin\":\"4\",\"end\":\"8\",\"score\":\"0.000000\"}]}}\t,{\"label\":\"service:safety\",\"score\":\"1.000000\",\"result\":{\"org_text\":\"欢迎来到安徽合肥，今天这里的天气很好\",\"org_wildchar\":\"####----#--#######\",\"score\":\"0.000000\",\"key\":[{\"mean\":\"service:safety\",\"text\":\"欢迎来到安徽合肥，今天这里的天气很好\",\"wildchar\":\"####----##########\",\"begin\":\"0\",\"end\":\"18\",\"score\":\"-13.898438\"}]}}]}";
        JSONObject obj = (JSONObject) JSONObject.parse(s);
        JSONArray array = (JSONArray) obj.get("result");
        array.forEach((Object x) -> {
            JSONObject temp = (JSONObject) x;
            JSONObject result = (JSONObject) temp.get("result");
            JSONArray tempArray = (JSONArray) result.get("key");
            tempArray.forEach(key -> {
                JSONObject jObj = (JSONObject) key;
                System.out.println(jObj.get("mean"));
                System.out.println(jObj.get("begin"));
                System.out.println(jObj.get("end"));
                System.out.println(jObj.get("text"));
            });
        });


        System.out.println();

    }

    @Test
    public void testArrayNode() throws Exception {
        String s = "可是你瞧，我却只能带十名侍卫，连一个小小知府的仪仗都不如这里边的文章，你们以为我看不出来吗你们只知有这么二十来个人跟在我的身边，可是，我敢说，就在我的后边三十里，至少有三千绿营兵在踩着我的脚印走在我们的前边，也有更多的兵丁在等着我的消息呢他们正在一站一站地向皇上传递着我的行踪，报告着我的动静别看今晚咱们在这里住下了，可前边驿站上的人正急得像热锅上的蚂蚁一样你们俩等着瞧吧";
        System.out.println(s.length());
    }

    @Test
    public void testMergeSentences() throws Exception {
        String text = "大清康熙六十一年的隆冬，纷纷扬扬的大雪铺天降落。这雪，给山河大地披上一层银装，又好像在为刚刚去世的老皇上康熙戴孝致哀。山峦起伏之间，风搅雪，雪裹风，掀起阵阵狂飙。这骤然而来的暴风雪，也仿佛在预示着新建立的雍正王朝那不平静的朝局。\n" +
                "这场大雪来得奇怪，它一下就下了整整一个冬天。东起奉天，北至热河，由山东河南又到山西甘陕各地，处处冷得出奇，雪也下得特别。它时而是零零散散飘着的细碎的雪花，时而又是滚滚团团漫天洒落的大片鹅毛。或星星点点，或铺天盖地，白皑皑，亮晶晶，迷迷茫茫，一片混沌。山峦，河流，道路，村舍，都变成了浑然一体的雪原，到处都是银白色的世界。偶而也会看到天光放亮，可那太阳只有惨淡苍白的一丝温柔，却没了平日的亮丽暖和。以致山村里的老百姓，一个个都钻到屋子里，猫在炕头上，谁也不肯轻易出门。\n" +
                "可是，就在这天寒地冻，风雪弥漫的时刻，却有一支马队，沿着冰封的山路，艰难地来到了我们面前。\n" +
                "这一小队骑兵来得特别，他们身上的服色也很不一致。在队伍的中间一匹高头大马上坐着的，是一位年轻的将领。他大约有三十来岁，穿着玫瑰紫挂面儿的玄狐巴吐鲁背心，外套猞猁猴的皮斗篷。略微有些瘦削的瓜子脸上，双眉紧皱，小胡子下两片嘴唇带着似笑非笑的冷竣，也透着几分高傲和轻蔑。护卫在他前面的有十个人，十个与众不同的人。他们都穿着四品武官的征袍，戴着白色透明的玻璃顶子。在八蟒五爪的雪雁补服外面，还披着白狐风毛的羔皮大氅。他们那虎背熊腰的身板和神气活现的架势，令人一看就知，他们是王府的护卫。走在那位将领身边的，是两个文官打扮的人。大概官职也不算太高，文绉绉，酸溜溜的，看样子像是从内务府来的笔帖式。他们的马后还跟着一大群兵丁，约摸有二十来个人的样子。这一行人现在正来到山西省娘子关外，在一座风雪弥漫的山神庙前停住了马。打头的护卫四外瞭望一下，简直分不清哪是道路，哪是沟壑。他连忙招呼队伍停了下来，自己跑到前边去打探路径。马上坐着的那位青年将领也不说话，用手按了按腰间冰冷的剑柄，仰望着渐渐黑下来的天色，长长地出了一口气。\n" +
                "探路的人回来了。他在那位将军面前翻身下马，就地打了一个千说：“十四爷，咱们走到绝路上来了，这前面五六十里大概也难找到宿头。奴才见这里有个破败的山神庙，香火早就断了，连个人影都没有。请爷示下，今晚是不是就在这里宿营？”\n" +
                "那位将军没有回答侍卫的问话，却转过头来，对那两个笔帖式说：“喂，钱蕴斗，蔡怀玺，你们二位是来押解我的，你们快发话呀。是走，是停，我悉听二位的吩咐。”\n" +
                "钱蕴斗和蔡怀玺两人一听这话，连忙翻身下马，在那位十四爷的马前打千跪下。叫钱蕴斗的赔着笑脸说：“哟，十四爷，您老这话奴才们可担当不起。就是折尽了奴才们的草料，奴才们也不敢听到爷这样说话。爷要说走呢，咱们这就紧紧地跟在后边；爷要是说不走了，奴才们立马儿给爷收拾住的地儿，全凭爷的吩咐办。再说了，皇上的圣谕只是要奴才们好好地服侍爷，让爷能平安顺溜地回北京去奔先帝的丧，也并没有限着日子不是。爷怎么说，就怎么好，奴才们谨遵爷的旨令。”\n" +
                "十四爷眉头一挑冷笑着说：“是吗？我说话还有这么大的分量？”\n" +
                "钱蕴斗和蔡怀玺偷眼瞟了一下十四爷，立刻被他那寒光闪闪、像利剑一样的眼神镇住，吓得他俩赶紧低下头去，不敢再多说什么了。\n" +
                "这位十四爷的脾气是有点儿怪，怪得谁见谁怕。因为他身份贵重，地位尊崇，不是常人能与之相比的。他就是刚刚去世的康熙皇上的第十四个儿子，统率十万大军镇守西疆、康熙亲口御封为“大将军王”的胤禵.\n" +
                "这位大将军王胤禵，可以说是威名显赫，声震天下。他生在天家，龙子龙孙，和当今皇上雍正，也就是胤祯，本是一母所生的两个皇子。当了皇上的胤祯，是老四，现在我们看到的是老十四。想当年，康熙老皇上还在世的时候，这兄弟西人就是势均力敌的老对头。他们为争夺皇储地位，也为了以后能当上皇帝，早就斗得不可开交了。可是，就在最紧要的时候，西蒙古发生叛乱。胤禵被派到了前线，胤祯则成了负责前线供应的“大总管”。身在前线的老十四是统兵的大将军，他自然是“主”；老四管着后方供应，就是“次”。可是后来康熙老皇上晏驾，胤祯继承了皇位，成了主宰天下生灵的雍正皇帝。老十四胤禵，没有夺得皇位，便只好屈居臣子，原来的兄弟，如今变成了君臣；他们的地位，也从此就有了天渊之别。当皇帝的哥哥不管说句什么，做臣子的弟弟都得乖乖地服从。胤祯一道诏书颁下去，胤禵就得马上回来奔丧；那诏书上写得明明白白，让他只带十名护卫，火速回京。他就是有天大的胆量，也不敢多带一个人；这诏书还不是直接交给胤禵的，而是通过手握重兵的年羹尧向他宣布的。因为当哥哥的雍正皇帝怕弟弟不从，早就在胤禵的军营四周布好军队了。只要胤禵稍稍有一点异动迹象，马上就要遭到灭顶之灾。\n" +
                "对他的这位四哥雍正，胤禵是太了解了。他们明争暗斗了这么多年，谁心里没有一本账啊。四阿哥胤祯，一向是个刚愎自用、猜忌心又特别强的人。不管你是谁，只要犯到了他的手上，他不把你整得七死八活是绝不放过的。眼下四哥当上了皇帝，自己却成了臣子，胤禵心里就是再不服气，碰上了这改朝换代的节骨眼上，又能怎么着呢？所以，他在从西边回来的这一路上，就只好拿这些侍卫们撒气。其中碰钉子最多，挨训挨得最多的，就是钱蕴斗和蔡怀玺两个人。他们俩是奉了“圣命”的人，不找他们的碴儿又去找谁呢？\n" +
                "钱蕴斗和蔡怀玺两个人都是小不拉几的官，在胤禵面前他们的日子确实不好过。来时，皇上给他们下了圣旨，说是要他们“平安”地“护送”十四爷早日进京。什么是“平安”？怎么做才叫“护送”？不就是要他们“看”好十四爷，不能让他在路上出事，不能让他和别人串通吗？除此之外，还能有什么呢？谁都知道这哥俩虽是一母同胞，心里想的却并不一样。他们之间的隔阂，也早已是人所共知的了。可谁敢不要脑袋，把这事给挑明了呢？皇上那“护送”的意思其实是“押解”，但这话圣旨上既然没写，谁也不敢照这个路子去胡想、胡猜。再说，你怎么知道，人家十四王爷回到京城里是个什么局面呢？兴许人家哥俩一见面就会拼刀子；也兴许人家看在一母同胞的份上，会忘记前嫌，重归于好。这全是皇上和十四爷的事，别人是管不着的。钱蕴斗和蔡怀玺更是不能管，也不敢管。所以，不论路上出了什么事，他们是不说不行，说得多了也不行；不巴结不行，巴结得太紧了也不行；光说好听的不行，说了十四爷不受用的话更不行。总之，他十四王爷胤禵要想找你的错，你想跑也跑不了。最好的办法，是什么也别说，什么也别问，想撒气就任十四爷撒好了。\n" +
                "十四爷见他们都蔫了，这才长舒了一口气。身边跟着的侍卫，紧跑两步在他的坐骑前跪下。十四爷踩着他的脊背下了马、活动了一下有点发麻的腿脚，搓了搓冻得通红的双手，对着钱、蔡二人又说上了：“不是我要发作你们，有些话我不能不说。我知道你们是奉着圣命来的，我就是再不懂事，也得对二位礼敬有加，这才是我的本份。这一路上是走是停，都要你们说了算，而且咱们还必须住在驿站里。因为这是皇上定下的规矩，你们得听，我也一样得听。今儿个天晚了，你们说要在这里住，我也就只好依着。这是你们自己说好了的，我才不希罕你们来装好人、送人情哪。这个鬼地方，前不巴村后不招店的，你们就不怕我在这里造反，或者是跑了？不过话又说回来，你们不怕，我又是怕的什么？”\n" +
                "在十四爷发作他们俩的时候，钱蕴斗和蔡怀玺一个劲地赔着笑脸，一声也不敢吭。直到十四爷说完了，钱蕴斗才小心翼翼地说：“十四爷，您老圣明，奴才们也是奉差办事，身不由己啊。奴才们只不过是小小的笔帖式，奴才们的上边，还有司、府、都太监、领侍卫内大臣……离皇上还隔着十八层天儿呢。上边说的话，我们敢不听吗？好歹您老体恤着点奴才，咱们平平安安地去到北京。等给先皇老佛爷尽了孝，奴才们的差事也就算办完了。往后，奴才们还要侍候爷，帮爷的光呢。”\n" +
                "十四爷听他说得可怜，自己一肚子的气也发作完了，这才跟着那群侍卫们走进了山神庙。\n" +
                "这个山神庙坐落在娘子关外一座山头上，居高临下，俯瞰万山。庙里的人不知在什么时候已经跑光了，只留下个空空的庙院。不过，房子倒没有怎么破坏，大殿的梁柱和回廊上的油漆还发着亮光，只是殿里的陈设却早被洗劫一空。这一大帮人刚要走进大殿，“呼”地一下，惊飞起躲在房顶和梁柱上的野鸟。蔡怀玺手疾眼快，一抄手就抓住了两只。他上前来笑着对十四爷说：“爷，您看，托您老的福，还真是没有白在这里住。待会儿，奴才把它烤熟了，给爷下酒。”\n" +
                "十四爷没有理他，却向外边的人吩咐一声：“快，把院子里的雪给我收拾干净了，廊沿下的栏杆拆下来烤火。钱蕴斗和蔡怀玺和我住大殿，我的侍卫们住西配殿，善扑营的人住在东配殿。”\n" +
                "外边的人“扎”地答应一声，各自分头干了起来。突然，东配殿里有人大叫一声：“妈呀！”随着喊声，又从里边跑出来几个人。这些人跑得慌忙，几乎与十四爷撞个满怀。十四爷一声怒喝：“瞎闹腾什么？”\n" +
                "“回十四爷，这，这里发现了一具尸体，还是个女的。”\n" +
                "胤禵跟着他们来到东配殿，果然看到墙角里蜷缩着一个年纪轻轻的小女子。不过，她的脸太脏，看不清模样，大约有十四五岁吧。只见她身上穿着一身用蓝线绣着边的青土布布衫，光着两只脚丫，用裹脚布把鞋子贴着前后心捆在一起，大概是因为这样可以暖和一些。她的小脸很难看，冻得乌青发紫还带着点灰色，像是在哪儿蹭了一脸的香灰。一群善扑营的兵士围在她的身边，一个个扎撒着手，品评着，议论着。大概是又怕沾了晦气又怕脏了手，谁也不肯上前把她拖出去。胤禵拿眼角瞧着他们，冷冷一笑说：“哼，你们也算是八旗子弟？我带的兵，在西大通和阿拉布坦打仗，一仗下来就尸积如山，血流成河。现在，一具女尸就把你们吓成这个样子了。真是胆小如鼠，给我禔鞋都不配！——来呀，我的亲兵护卫呢？”\n" +
                "“在！”\n" +
                "“把她拖到庙外，扔得远远的。”\n" +
                "“扎！”\n" +
                "一个护卫答应一声，拖着那女子就向外走。可是，刚走了几步却又停了下来：“十四爷，这女子没死，她胳肢窝里还有点热乎哪！”\n" +
                "“什么，什么，有这样的事？”胤禵走上前来，用手把住那女子的脉搏仔细地诊视了一会：“嗯，是还活着。来，你们把她搭到大殿里，放到火边上让她烤烤火，兴许还能救过来。”\n" +
                "众人七手八脚地把女子弄到大殿里的火跟前，有人又烫了一碗黄酒，翘开她咬紧的牙关灌了下去。不大一会儿，她的脉搏跳得有力了。再等一会儿，鼻翅一张一合地好像有了气，脸色也有点泛红，只是还没有完全醒过来。\n" +
                "胤禵不再管她，坐在火塘边上默默地想心事。侍卫们早把大殿里打扫干净了，火架子上，烤熟了的鹿肉发出阵阵的香味。一滴滴的油溅在火上，“滋滋”地响着，冒出悠悠的青烟。钱蕴斗拣了一块烤得焦黄的鹿肉，双手捧着送到十四爷面前。他却摇头说：“你们吃去吧，我一点儿都不觉得饿。你听，他们在东配殿里正喝酒哪，你们要是想去就只管去。放心吧，我不会跑也不会寻死上吊！”\n" +
                "钱蕴斗勉强笑了笑说：“十四爷，您老别太难过。奴才说句不知进退的话，先帝爷在位六十一年，圣寿也快七十了。在老百姓的眼里，能活到这么大的高寿，应该说是喜丧。所以依奴才看，您也不必老跟自己过不去，您得保重啊！”\n" +
                "胤禵重重地叹了口气：“唉，你说得也对。老钱哪，你们不要怪我十四爷的脾气不好，我这是心里难受啊！先帝爷在康熙五十六年时，封我为大将军王，让我带兵去青海平叛。临行时，先帝爷把我一直送出午门。他老人家拉着我的手说：”朕老了，身子骨也不好。朕知道你不愿出这趟远门，可是，你不去，又有谁能替朕分忧，给朕尽孝呢？‘皇阿玛说这话的时候，老泪纵横，不能自已。可我万万没有想到，这一去就再也见不到我的皇阿玛了……“胤禵说着说着，已是潸然泪下。\n" +
                "二回　救贫女馈赠金瓜子　惩贪官造就新污吏\n" +
                "蔡怀玺在一旁说：“十四爷，刚才老钱说的有道理。您是金尊玉贵之体，千万不要太过于伤心了。奴才们知道，当今主子给先帝办后事，是十分隆重的。奴才还去遵化先帝的陵寝瞻仰过，那里不但十分壮观，风水也好。当今万岁正是怕十四爷过于悲恸，这才叫奴才们星夜兼程去西大通的。为的就是早一天把爷接回京城，和阿哥们一起把先帝的丧事办得更好。先帝爷在位六十一年，这丧事可不能办得马虎了。您老一回京，就不能歇着了，所以更要节哀才是。”\n" +
                "胤禵又是一声长叹：“唉，四哥刚毅果断，他当皇帝我还有什么可说的。只不过我有几句话想问问你们二位。你们要是想着自己是正黄旗下的奴才，就给我说实话；你们要是想着这是办的皇差，是奉了圣旨来押解我这倒了霉的王爷进京的，那就算我没说。不但今天不说，而且从今以后，你们就把我当成哑巴算了。”\n" +
                "钱蕴斗和蔡怀玺一听这话，傻了！十四爷他，他要说什么呢？\n" +
                "钱蕴斗和蔡怀玺他们正陪着十四爷说话，听着这位大将军王越说越不可捉摸，他俩心里吃惊了。钱蕴斗的心思灵便一些，连忙说：“十四爷，您老这是起了疑心了吧？一定是看着我们俩有什么心思瞒着您。其实皇上对您老真没有一点见外的意思，要不怎么能只派了二十个人来护送王爷呢？爷今天有什么话您只管问，凡是奴才们知道的，断不敢有丝毫欺瞒不说的道理。”\n" +
                "胤禵突然仰天大笑：“哈哈哈哈……钱蕴斗啊钱蕴斗，你是给我装傻呀还是真的不明白？你说皇上没和我见外，那我问你：为什么皇上在向我传旨前，先给陕西总督年羹尧下旨，命令甘陕两省戒严？他为什么又命令四川巡抚蔡珽带着两万人马赶到老河口去集结待命？他不是在防备我又是怕的什么？”\n" +
                "钱蕴斗忙说：“十四爷，这您可是误会了。先帝爷驾崩，事出仓促，朝野惊恐，当今万岁才下旨天下兵马一律戒严的。不光是甘陕和四川，直隶也不例外，北京城里九门都封了！”\n" +
                "“好，就算你说得有理。我再问你：早先在四哥跟前伺候笔墨的那个小兔崽于李卫，现在当了陕西布政使。他的差事是专管供应西路大军的军粮，原先是三个月就送一次粮的，可是，为什么却改成按日供给？”\n" +
                "“这，这，这奴才可说不上了……”\n" +
                "在一旁的蔡怀玺忙说：“十四爷您甭多想。您瞧这大雪，粮食一时供应不上，也是常有的事嘛……”\n" +
                "“住口！蔡怀玺，到现在你还敢跟爷来这一手？告诉你，爷不是好欺哄的！爷是圣祖大行皇帝亲口御封的大将军王，是奉旨奔丧的天璜贵胄。可是你瞧，我却只能带十名侍卫，连一个小小知府的仪仗都不如。这里边的文章，你们以为我看不出来吗？你们只知有这么二十来个人跟在我的身边，可是，我敢说，就在我的后边三十里，至少有三千绿营兵在踩着我的脚印走。在我们的前边，也有更多的兵丁在等着我的消息呢！他们正在一站一站地向皇上传递着我的行踪，报告着我的动静。别看今晚咱们在这里住下了，可前边驿站上的人正急得像热锅上的蚂蚁一样。你们俩等着瞧吧，到不了明天早晨，他们非得来‘迎接’我不可。因为他们怕万一我这儿出了事，就有人要砍了他们的脑袋！”\n" +
                "十四爷越说越激动，他突然站起身来奔到窗前，手扒窗棂用力地摇晃着，炯炯的目光好像要穿透外面那沉沉的黑夜。他的脸上早已满是泪痕，他不住地在心里喊着，叫着，也在心里骂着：八哥，九哥，十哥，你们在京城都干了些什么，难道你们竟是一群酒囊饭袋吗？你们当中不管是谁抢了这皇位，也比让四哥夺走强啊。难道你们不知道，他一旦掌了乾坤，就会对兄弟们下毒手吗？那个该死的鄂伦岱，我派你回京干什么去了？我是让你给我打探消息的，可你怎么连一点信息都不给我透，硬是让我遭到今天这样的下场呢？\n" +
                "面对处在暴怒中的胤禵，钱蕴斗和蔡怀玺二人哪敢开口说话呀。他们对望了一眼，又赶紧低下了头。钱蕴斗把火拨得更旺一些，目不转睛地看着陷入沉思中的这位王爷。胤禵的心仿佛又回到了他出征前的那一夜，他去向病中的八哥告辞的时候……\n" +
                "那天，八哥胤祯头上缠着黑帕，气喘吁吁地出来见他。记得当时八哥说：“十四弟，我的好兄弟，你就要远行了，我真不忍和你分手啊。千不该万不该，我们兄弟不该生在皇家！我本来是想一生只做好事，当个贤王，可是我……唉，种的是花，收的却是刺，连皇阿玛也不待见我了……北京不是个好地方，它是虎狼穴、是非窝！几个兄弟都在眼睁地等着黄袍加身，我们的难处苦处有谁知道啊！如今我已病成了这个模样，你这一走恐怕就是我们的永别了……我有一句话想对你说，在这内忧外患交相袭来的时候，越是离得远，倒越是平安无事。我把我的奶公派给你，有他在你的身边侍候着，就和我在你跟前一样。你只管放心地去吧，一旦朝局有变，我在京城里替你维持着，你带着十万八旗子弟兵临城下。只要咱们兄弟联手，这皇帝的龙椅，你不来坐又有谁敢坐它？”\n" +
                "胤禵几乎是被他说动了，他哽咽着回答说：“八哥你说的都对，唯独当皇帝这一条，我却从来没有想过，我是员武将，也只会带兵，既没有你那样的度量，也没有你那样的人望，据小弟看，皇上对你还是抱着很大期望的。别看皇阿玛当众训斥了你，可是，马上又封你为亲王。他老人家这是在磨炼你呀，你懂吗？要我说，你就放宽心养病吧。我只求你一件事，就是万一京城有了什么大事，你一定要给我透个信去……”\n" +
                "当时，八哥信誉旦旦。他说，你只管放心走吧，京城里只要有我在，咱们就绝对吃不了亏。别看这哥俩面对面的时候说得很好，可是，他们的心里却都有自己的章程，也各自都在打着如意算盘。胤禵不傻，他能不知道八哥的目的吗？他把奶公和那个鄂伦岱送上前线去，不就是为了监视胤禵吗？所以，胤禵一到西大通、就先收买了鄂伦岱，还把这小子又派回京城去打听动静。八哥的奶公收买不动，就行军法杀了他。哼，你们也想来抢皇位，放着我的十万兵马，你们谁也别想得逞！可是，想不到他还是晚了一步，连八哥也晚了一步。鹬蚌相争，渔翁得利。本来没有什么希望的四哥，却顺顺利利地粉墨登场，当上了这九五至尊。自己不但不能率领十万大军入关，反倒被二十名兵丁半是护送半是押解地送往京师……\n" +
                "一丝莫名其妙的疑虑、惆怅、愤怒轰浦怖一起袭上心头，他“咔”地一声，把窗棂拉断。刚要发火，可是窗格上落下了一片灰尘，使得他猛然一下又清醒了过来。不能啊，如今大势已定，我再要盲动，岂不是飞蛾投火，自取灭亡。他十分清楚，只要自己稍有不慎，就连眼前这些兵丁，也不会轻易地放他过关的！他走到火塘跟前，顺手把那窗棂扔进了火里，又颓然坐下了。\n" +
                "就在这时，那个被他们救活的女孩子醒过来了。只听她用十分微弱的声音叫着：“水……水……”[txt下载 www.txtxiazai.com.cn] \n" +
                "十四爷刚要起身，钱蕴斗连忙上来说：“爷，您老先歇着，这事交给奴才好了。”说着便走近那个女子，替她把了脉，高兴地说：“十四爷，托您的福，这孩子的脉很平稳。她这是在说胡话呢，哪里是渴呀。来，老蔡，你给她盛上一碗热肉羹来。”\n" +
                "蔡怀玺听了这话很是兴奋：“好好好，老钱哪，你要是能把这小妞救过来，不光是十四爷高兴，也是咱们积了阴德了。”他一边说着，一边把一碗滚烫的肉羹给她灌了下去。\n" +
                "不一会，就见那姑娘果然睁开了眼睛。她茫然地看着周围的人们，声音微弱地问：“我，我这是在阴曹地府里吗？”\n" +
                "钱蕴斗告诉她说：“姑娘你瞧，这里不还是那个破山神庙吗？告诉你吧，你被冻死了，饿死了，可是又被我们爷给救活了。你交上好运了，知道吗？”\n" +
                "那姑娘忽闪着两只大眼，想了又想。突然，她好像意识到了什么，挣扎着爬起身来就要给身边的人磕头。可是，她毕竟是太虚弱了，刚一抬头，就又倒了下去。她一个劲地喘息着，口齿不清地说：“众位爷，你们都是好人，是我的救命恩人。我，我……”\n" +
                "胤禵来到她的身边问：“你叫什么名字，有家吗？为什么会倒毙在这里？”\n" +
                "那女子看出来了，这个问她话的人有些与众不同。她恭恭敬敬地回答说：“这位爷，小女子是山西代县乔家寨的人。我姓乔，叫引娣，家里还有爹妈和一个小弟弟。去年我们那里遭了旱灾，颗粒不收。全家都在饿肚子，更交不上县里派的官租轰莆税银子。上边来人催得紧，爹没办法，只好把我卖给一个苏州人。原来说的是到那里学刺绣，学好了孝敬皇上的。谁知道他却是个人贩子，要把我们这群女孩子卖到妓院去。我瞅着机会偷跑了出来，一路要饭来到这里，不巧碰上了这场大雪。原来我想在庙里躲躲的，哪知一坐下就没能站起来……”\n" +
                "胤禵听了这话，冷冷一笑说：“嗬，看不出你小小年纪倒挺会说假话！你左一套右一套的，哄得人直想掉眼泪。不过你说得不对，也瞒不过爷的眼睛。不错，去年山西是遭了灾。可是康熙万岁爷已经下诏，不但免去了山甘两省的钱粮，还派了钦差大臣会同山西巡抚诺敏赈济灾民。怎么还会有官府派人催这事，怎么会有你说的那些人贩子？你老实说吧，你是谁家的逃奴，为什么跑了出来？我一向是救人救到底，送佛上西天的。你只要说出实话来，我自会给你作主的。”\n" +
                "引娣流着泪说：“爷，我说的全是真话呀！您老要是不信，我也没办法。民女也不知道这事的内情，好像听村里人说，您老说的那位诺大人欠了谁的银子……对对，是欠了国库的银子。他自己还不上，就要百姓替他还。爷说的那个赈灾的事是没有的，不但没人来救灾，原来的课税银子还得加倍收缴。诺大人的钱还不够用呢，怎么还能免了百姓的？赶明儿，爷到下边叫个老乡一问，就知道我说的是不是实话了。”\n" +
                "胤禵不言声了。引娣说的他当然知道，而且他还知道这正是当年的雍亲王、如今的雍正皇帝、自己的四哥造的孽。康熙四十六年，四哥掌管户部。他为了清理官员们积欠的国库银两，把这些官们一个个都没了活路，投井上吊的都有。可当时只有这个诺敏，不知他有什么不同一般的办法，不但还清了积欠，还得了彩头。为此，四哥着实的夸奖他了一番，说他堪称模范。哦，原来他用的是羊毛出在羊身上的办法。自己欠了钱，却逼着老百姓替他还。好好好，要不是我今天亲耳听到，还真不敢小看这位诺大人哪。这就是当今雍正皇帝的德政，这就是你那过人的精明！他回过头来问：“哎，我说二位，你们谁知道这个诺敏的底细？我好像记得他是雍王府的人，是吗？”\n" +
                "钱蕴斗知道，但他不敢说。蔡怀玺比较老实，他说：“十四爷，这个诺敏不是当今万岁龙潜时的门下，他是镶白旗的。是，是……是年大人的换帖兄弟……”\n" +
                "十四爷一听，又和年羹尧连上了，气得他骂了一声：一丘之貉！回过头来，他又对引娣说：“你这小丫头大难不死，也许会有后福的。爷问你，你是愿意到北京去侍候爷，还是愿意回家去呢？”\n" +
                "引娣趴在地上磕了个头说：“爷，小女子谢谢爷的好心。可是，我家里上有父母，下有兄弟，实在是放不下心去。我，我……”\n" +
                "“好了好了，别再说了。你有这份孝心，真比我那些个兄弟们强。爷随身没带银子，这里有一把金瓜子，你拿去用吧。”说着从口袋里掏出一把金瓜子来给了引娣。引娣还从来没见过这东西哪，捧在手里看了又看，希罕得不行。等她悟过神来，要向这位将爷道谢时，却见他己靠在墙角睡着了。\n" +
                "黎明时分，正在熟睡的胤禵被叫醒了。钱蕴斗报告说，前边井径驿站派人来接十四爷来了。胤禵看了钱蕴斗一眼，那意思是说：怎么样，我的估计没错吧。钱蕴斗低下头，不敢说话了。胤禵看见，就见面前的廊沿下，站着一个浑身是雪的人，连眉毛胡子都结着一片冰碴儿。可见昨夜的雪下得够大的，天也真够冷的。胤禵示意他进来回话，那人连忙磕磕绊绊地走上前来行礼说：“井井井径……驿驿……驿丞，孟孟孟……”\n" +
                "胤禵一听，咳，原来是个嗑巴。他笑了：“行了行了，你别为难了，不就是孟驿丞吗？你起来吧。”\n" +
                "“奴奴奴，奴才盂……宪佑给……爷请安！”一边说着，又打了一个千。他大概是第一次见到身份这么高贵的王爷，有点紧张，也有点害怕。可是，越紧张、越害怕就越是说不出话来。胤禵本来想通过他的嘴问一问前边的情形哪，不料却碰上了这么一个活宝。听着他嗑巴了好大半天，才知道了事情的原委。原来是户部员外郎田文镜要去前线劳军，打从这里经过，带来了保定府的宪令。说让他们一听到十四爷的消息，就立刻派暖轿前去迎接，井径这位孟驿丞不敢怠慢，昨晚跑了足足五十里山路，才来到这里。现在暖轿就在外边，请十四爷坐上轿子赶路，免得再受风雪之苦。\n" +
                "听到这个消息，胤禵真是觉得哭不得也笑不得了。过去他曾听人说起过田文镜此人，好像也是从四哥府里禔拔上来的。好嘛，为了紧紧地“看”住我，四哥真是不惜动用所有的力量啊！五十里风雪山路，这位孟驿丞是怎么爬上来的呢？好好好，我这就动身，别让他们再为难了。\n" +
                "胤禵临行前，乔引娣又来到他身边磕头告别。经过这一夜的休息，她好像已经缓过来了。在轿外泪光闪闪地看着十四爷。就在这一瞬间，胤禵突然发现她长得很美。刚刚用雪水洗过的脸上，泛着粉嫩的红晕，嘴角下还有两个似隐若现的酒窝。一头乌黑的头发，虽然有些散乱，却黑得像乌鸦翅膀在晨风中抖动。同样黑得深不见底的瞳仁中带着稚气，也带着与她年龄不相符的成熟。胤禵忽然想到，自己的王府中虽然使女不少，可是却没有一个能和她相比。如果她愿意，不如把她带回去，就是让她去侍侯福晋也是好的嘛。可又一转念，我如今身在危途，吉凶难料，带上她干什么？他正要传令起轿，却听引娣在轿外说：“恩公，乔引娣请您老留个姓名，好让小女子回去以后，给您老立个长生牌位。”\n" +
                "三回　进京城将军藐皇权　闹灵堂王爷逞威风\n" +
                "胤禵一愣，随即又仰天长笑：“哈哈哈哈……真是个傻丫头！自古以来，哪有长生不老之理？我只要不短命就是天大的造化了。”其实他还想说一句，先帝在位时，天天听着文武百官们喊万岁，现在不是也去了吗？他老人家不是也才当了六十一年的皇帝吗？不过他看看站在轿外的人，这句话没有说出口来。他回头又看了一眼乔引娣，对着侍卫们说了声：“起轿！”\n" +
                "乔引娣听见这一声喊，连忙翻身跪倒磕头，眼睁睁地看着十四爷一行人消失在弥漫的风雪里。\n" +
                "冬至前两天，胤禵一行经过艰难跋涉，终于来到了京城。按胤禵的意思，本来想马上进宫去给父皇守灵尽孝的。可是，来接他的宫中侍卫一道旨意传下，命他暂在璐河驿歇马，等候皇上宣召。胤禵心里不痛快了，好嘛四哥，给我来真格的，摆起皇上的架子来了。想当初我统带兵马出征西行时，还是你亲自到这里给我送行的。可今天我回来奔丧，竟然不让我进城了。好，咱们走着瞧，我看你到底有多大能耐！\n" +
                "内务府早就奉了圣旨，当天晚上就派人来到璐河驿，说是要在这里陪伴十四爷。胤禵心里清楚，这哪是什么“陪伴”，分明是来打探动静和监视他的。来的人不少，领头的是内阁大学士尹泰。胤禵知道他是位有名的道学先生，今年已经是快七十岁的人了，又是当年太子胤禵的老师。他也知道，尹泰早在康熙年间，就受到父皇的特别重用。因此，胤禵不敢对他有一点不敬，便恭恭敬敬地问道：“尹老夫子，依您看，我是应该先去拜见皇上，还是先去给先帝爷磕头呢？”\n" +
                "尹泰起身行礼说：“十四爷，请恕老臣直言。依老臣看，忠孝本为一体，尽忠即是尽孝。十四爷思念先帝，看重孝道，人子之情，可钦可敬，也是理所当然的；但依老臣看，最好还是先见见皇上，然后再去守灵更合乎道理。何况明日十四爷进宫时，当今万岁一定也在乾清宫。先行君臣之礼再为先皇尽孝，才是应当的。”\n" +
                "胤禵一听这话就觉得窝心：“尹老大人，您说的有道理。但孝为忠之本，不孝即是不忠。古往今来，哪个忠臣不是孝子？既然您刚才说，皇阿玛的梓宫就在乾清宫，那我就先去乾清宫尽孝，别的事看情形再说吧。”\n" +
                "尹泰听出来了，十四爷并不满意他的回答，说话的口气里也好像是话里有话。可他是个老实人，根本无意搅和到是非中去。便说：“十四爷，有一件事臣应该回禀爷知道，先帝爷的谥号已经定下来了。今后无论是什么场合，也无论是谁，都要敬称‘圣祖’。这一点，要请爷特别注意；再就是当今万岁登基后，因为要避圣讳，所以各位阿哥名字中的‘胤’字，都改成了‘允’字。胤和允读音相近，口头称呼是不容易听清的。如果要写成奏折，请爷注意更正过来。”\n" +
                "“好好好，多谢尹老大人禔醒，我多加注意也就是了。”\n" +
                "胤禵不想多说，他现在心里最急于知道的，是朝中的动静，是其他几位阿哥的消息。他向下边一看，今天来的人非常杂乱。既有四哥的亲信，也有八哥、三哥他们身边的人，哪党哪派的人都有。这种情形下，很多话都不便说出来。其实，就这么一看之下，胤禵什么全都明白了。既然各派都有人来，那就是说，朝中眼下还不是四哥的一统天下，他就还有机会和四哥说话。至于要说什么，可就是你们这些人管不着的了。\n" +
                "第二天一大早，太监便来传旨说：“着大将军王允禵，即刻到乾清宫圣祖梓宫前见驾。”胤禵一听，什么什么，好大的口气呀！哼，要我在圣祖梓宫前见驾。好吧，我是要到圣祖灵前的，但会不会去“见驾”，那可由不得你了。听完太监的宣召，他既不跪拜磕头，也不口称领旨谢恩，而是转回身去跃上马背，打马就走。闹得从尹泰到下边的人一个个神情尴尬，说不敢说，拉不敢拉，劝又不敢劝，只好紧紧地跟着他往城里跑。胤禵看着他们的狼狈相直觉得好笑。他在心里说：你们等着瞧吧，爷还有好戏在后边呢！\n" +
                "刚到紫禁城门口，就见老侍卫德楞泰在宫门前正等着他。他知道这位德楞泰是先皇身边最得力的人之一，便连忙走上前去，想和他打招呼。可德楞泰把脸一沉说：“有旨意。”按规矩，德楞泰一说这话，十四爷就要立刻跪下，口称：“臣允禵接旨。”或者说：“臣允禵恭聆圣谕”才对。可允禵好像没听见，仰着头沉着脸，一副满不在乎的样子——他根本不吃这一套！德楞泰见他丝毫没有接旨的意思，也不敢勉强，口宣圣旨说：“着允禵到乾清宫西暖阁见驾，钦此。”说完了也不管允禵愿意不愿意，谢恩不谢恩，自己先按规矩上前来打了一个千说：“奴才德楞泰给十四爷请安。”\n" +
                "允禵黑着脸说：“早上不是已经传过一次旨意了吗？怎么说变就变，这么多事儿呢？”\n" +
                "德愣泰忙说：“万岁爷的意思，是先请十四爷见一见面，然后再一同去大行皇帝灵前行礼。”\n" +
                "允到“哼！”的一声，抬腿就走。他在心里说，让我先见你，没门！我偏不听你这一套，看你能把我怎么样。德楞泰和尹泰两个人都知道，这位十四爷脾气大。平常日子里还谁都不敢惹哪，现在他心里正有气，你要是上前劝阻他，还不得找着挨骂呀。可是，他们一看，允禵走着的却不是平常人可以走的路。他走的是从午门进去，迈过金水桥，直通乾清宫的中路，这条路在平日是没人敢走的，除非是有了大事，或者是皇上亲自批准，不然的话，就要以失礼而受到惩处。可是，允禵却不管这一套规矩。人们看着他进去以后，便直奔太和殿，然后，穿过中和殿，在保和殿后下了台阶，又闯过乾清门，沿着甬道，看也不看一眼两列钉子般的侍卫们，一直地向前走。在隆宗门外专门等候的上书房大臣隆科多，一见这阵势可吓坏了。他连忙飞也似的跑了过来，嘴里还喊着：“奴才给十四爷请安。”可十四爷现在连皇上还看不到眼里呢，哪还顾得上他这个舅舅？他眼下心里想着的，就是要给这位刚刚登基的皇上来一个下马威！两旁的侍卫们都看得呆了，谁也不清楚十四爷今天是怎么回事。他为什么这样大胆，又为什么这样不顾礼法呢？可是，他们却谁也不敢上前去拦阻。\n" +
                "到了，到了，乾清宫就在面前了，看得见为老皇上致哀的灵幡在迎风飘舞了。允禵只觉得心里一阵悲痛，一阵昏眩。眼前的天地、宫殿，好像都在飞快地旋转，飞快地涌动。他加快了脚步，向着有人的地方奔去，向着有声音的地方奔去。\n" +
                "乾清宫大殿上的“正大光明”牌匾，好像在放着灼目的光亮。牌匾下边，满目都是白色的幛幔、白色的屏风，白色的几案，白色的孝服。冷风吹过，一片呜咽之声响在耳边。他在心中高喊一声：“皇阿玛，您的儿子回来了！”就发了狂向前奔去。\n" +
                "恍恍惚惚中，突然有两个人、两双大手紧紧地从两边架住了他，还有个清晰而又十分熟悉的声音说：“十四弟，你这是怎么了？你要挺住啊！”\n" +
                "他失神地向两边看了一下，原来站在他左边的是八哥允禩，而在右边架住他的却是十三哥允祥！他停住了脚步，向上边望了一眼。只觉得浑身颤抖，心潮涌动。他大叫一声，便扑倒在地，匍匐着，哭喊着，爬到康熙的灵柩前：“皇阿玛呀，您醒醒，醒醒啊！您的不孝儿子……老十四回来看您来了。儿子临走前，您不是亲口对我说，您一定要再见到我的吗？可是，儿子回来了，您却躺在这里边。儿子再也不能见到您，听您说话了。我的好阿玛，儿子思念您、心疼您，您知道吗……”\n" +
                "允禵这番哭是发自内心的。";
        String[] strings = StringUtils.splitPreserveAllTokens(text, ".。?？！!\n\r\t");
        Arrays.asList(strings).stream().forEach(System.out::println);
    }


}
