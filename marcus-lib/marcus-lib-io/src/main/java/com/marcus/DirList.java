package com.marcus;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 目录列表器
 * @author marcus
 *
 */
public class DirList {
	public static void main(String[] args) {
		File path = new File(".");
		String[] list = path.list();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}

//文件姓名过滤器
class DirFilter implements FilenameFilter {
	
	private Pattern pattern;
	
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}
