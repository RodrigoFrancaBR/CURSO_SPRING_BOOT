package br.com.franca.domain.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

	public static <O, D> D parseObject(O sourceObject, Class<D> destObject) {
		return mapper.map(sourceObject, destObject);
	}

	public static <O, D> List<D> parseListObjects(List<O> sourceObjectList, Class<D> destObject) {
		ArrayList<D> destObjectList = new ArrayList<D>();
		sourceObjectList.forEach(sourceObject -> destObjectList.add(mapper.map(sourceObject, destObject)));
		return destObjectList;
	}
		
}
