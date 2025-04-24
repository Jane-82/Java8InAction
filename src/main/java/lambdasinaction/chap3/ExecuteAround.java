package lambdasinaction.chap3;

import java.io.*;
public class ExecuteAround {

	public static void main(String ...args) throws IOException{

        // method we want to refactor to make more flexible
		// 原方法
        String result = processFileLimited();  // 当前工作目录为 Java8InAction
        System.out.println(result);

        System.out.println("---");

		// Lambda
		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

	}

	// 原方法
    public static String processFileLimited() throws IOException {
		// Java7：带资源的try语句，会自动关闭资源
        try (BufferedReader br =
                     new BufferedReader(new FileReader("src/main/java/lambdasinaction/chap3/data.txt"))) {
            return br.readLine();
        }
    }

    // Lambda优化步骤：2
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/lambdasinaction/chap3/data.txt"))){
			return p.process(br);
		}

	}

	// Lambda优化步骤：1
	public interface BufferedReaderProcessor{
		// 使用函数式接口：匹配方法签名 BufferedReader-> String，抛出IO异常
		public String process(BufferedReader b) throws IOException;

	}
}
