package com.blog.utils;

import java.util.Date;
import java.util.Set;

import com.blog.domain.Article;

import redis.clients.util.JedisByteHashMap;

public class BuilderUtils {
	
	@SuppressWarnings("unchecked")
	public static Article builderArticle(JedisByteHashMap map){
		Article article = new Article();
		byte[] id = SerializeUtils.serialize("id");
		if(map.containsKey(id)){
			article.setId((Long) SerializeUtils.deserialize(map.get(id)));
		}
		byte[] title = SerializeUtils.serialize("title");
		if(map.containsKey(title)){
			article.setTitle((String)SerializeUtils.deserialize(map.get(title)));
		}
		byte[] type = SerializeUtils.serialize("type");
		if(map.containsKey(type)){
			article.setType((String)SerializeUtils.deserialize(map.get(type)));
		}
		byte[] date = SerializeUtils.serialize("date");
		if(map.containsKey(date)){
			article.setDate((Date)SerializeUtils.deserialize(map.get(date)));
		}
		byte[] content = SerializeUtils.serialize("content");
		if(map.containsKey(content)){
			article.setContent((String)SerializeUtils.deserialize(map.get(content)));
		}
		byte[] comments = SerializeUtils.serialize("comments");
		if(map.containsKey(comments)){
			article.setComments((Integer)SerializeUtils.deserialize(map.get(comments)));
		}
		byte[] author = SerializeUtils.serialize("author");
		if(map.containsKey(author)){
			article.setAuthor((String)SerializeUtils.deserialize(map.get(author)));
		}
		byte[] tag = SerializeUtils.serialize("tag");
		if(map.containsKey(tag)){
			article.setTag((Set<String>)SerializeUtils.deserialize(map.get(tag)));
		}
		return article;
	}
}
