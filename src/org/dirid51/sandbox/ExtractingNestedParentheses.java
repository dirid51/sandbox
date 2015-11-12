package org.dirid51.sandbox;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractingNestedParentheses {

	public static void main(String[] args) {
		String testString = "In a certain home, a little boy, the only son, was ill with an incurable disease. Month after month the mother had tenderly nursed him, but as the weeks went by and he grew no better, the little fellow gradually began to understand the meaning of death and he, too, realized that soon he was to die. One day his mother had been reading the story of King Arthur and the Knights of the Round Table, and as she closed the book the boy lay silent for a moment, then asked the question that had been laying on his heart. “Mother, what is it like to die? Mother, does it hurt?” Quick tears filled her eyes. She sprang to her feet and fled to the kitchen, supposedly to go get something. She prayed on the way a silent prayer that the Lord would tell her what to say, and the Lord did tell her. Immediately she knew how to explain it to him. She said as she returned from the kitchen, “Kenneth, you will remember when you were a little boy, you would play so hard you were too tired to undress and you tumbled into your mother’s bed and fell asleep. In the morning you would wake up and much to your surprise, you would find yourself in your own bed. In the night your father would pick you up in his big strong arms and carry you to your own bedroom. Kenneth, death is like that; we just wake up one morning to find ourselves in the room where we belong because the Lord Jesus loves us.” The lad’s shining face looked up and told her there would be no more fear, only love and trust in his heart as he went to meet the Father in heaven. He never questioned again and several weeks later he feel asleep, just as she said. That is what death is like. (See Catherine Marshall, A Man Called Peter (New York: McGraw Hill, 1951), pp. 272–73.)";
		String testString2 = "\"When the souls shall return to the presence of the Father of all, the worthy mothers will be there to welcome their worthy children. \" (Immortality and Eternal Life [Melchizedek Priesthood Course of Study, 1969–70], vol. 2, pp. 24–28.)";
		Pattern pattern = Pattern.compile("\\(.+\\)");
		Matcher matcher = pattern.matcher(testString);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		Matcher matcher2 = pattern.matcher(testString2);
		while (matcher2.find()) {
			System.out.println(matcher2.group());
		}
	}

}
