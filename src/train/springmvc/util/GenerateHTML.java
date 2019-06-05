package train.springmvc.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 生成纯静态的HTML文件
 */
public class GenerateHTML {
	
	/**
	 * 生成纯静态的HTML文件
	 * 
	 * @param folderName 文件夹名称
	 * @param ftl FTL文件
	 * @param htmlName HTML文件名
	 * @param map Key-Value数据
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void generateHTML(String folderName, String ftl, String htmlName, Map<String, Object> map, ServletContext servletContext) throws IOException, TemplateException {
		Configuration cfg = new Configuration();
		cfg.setServletContextForTemplateLoading(servletContext, File.separator + folderName);
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		Template template = cfg.getTemplate(ftl);
		template.setEncoding("UTF-8");
		String path = servletContext.getRealPath("/");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + htmlName));
		File htmlFile = new File(path + htmlName);
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
		template.process(map, out);
		bufferedWriter.close();
		out.flush();
		out.close();
	}

}
