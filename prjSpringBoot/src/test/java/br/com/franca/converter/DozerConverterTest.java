package br.com.franca.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.franca.converter.mocks.MockUnidade;
import br.com.franca.domain.Unidade;
import br.com.franca.domain.converter.DozerConverter;
import br.com.franca.domain.enun.Status;
import br.com.franca.domain.vo.UnidadeVO;

public class DozerConverterTest {
	MockUnidade mockUnidade;

	@Before
	public void setUp() {
		mockUnidade = new MockUnidade();
	}

	@Test
	public void parseEntityToVOTest() {
		UnidadeVO unidadeVO = DozerConverter.parseObject(mockUnidade.mockEntity(), UnidadeVO.class);

		Assert.assertEquals(Long.valueOf(0L), unidadeVO.getKey());
		Assert.assertEquals("CASCADURA0", unidadeVO.getNome());
		Assert.assertEquals("RUA X 5000", unidadeVO.getEndereco());
		Assert.assertEquals(Status.ATIVA, unidadeVO.getStatus());
	}

	@Test
	public void parseEntityListToVOListTest() {
		List<UnidadeVO> listaDeUnidadeVO = DozerConverter.parseListObjects(mockUnidade.mockEntityList(),
				UnidadeVO.class);
		UnidadeVO unidadeVOZERO = listaDeUnidadeVO.get(0);

		Assert.assertEquals(Long.valueOf(0L), unidadeVOZERO.getKey());
		Assert.assertEquals("CASCADURA0", unidadeVOZERO.getNome());
		Assert.assertEquals("RUA X 5000", unidadeVOZERO.getEndereco());
		Assert.assertEquals(Status.ATIVA, unidadeVOZERO.getStatus());

		UnidadeVO unidadeVOSETE = listaDeUnidadeVO.get(7);

		Assert.assertEquals(Long.valueOf(7L), unidadeVOSETE.getKey());
		Assert.assertEquals("CASCADURA7", unidadeVOSETE.getNome());
		Assert.assertEquals("RUA X 5007", unidadeVOSETE.getEndereco());
		Assert.assertEquals(Status.ATIVA, unidadeVOSETE.getStatus());

		UnidadeVO unidadeNOVE = listaDeUnidadeVO.get(9);

		Assert.assertEquals(Long.valueOf(9L), unidadeNOVE.getKey());
		Assert.assertEquals("CASCADURA9", unidadeNOVE.getNome());
		Assert.assertEquals("RUA X 5009", unidadeNOVE.getEndereco());
		Assert.assertEquals(Status.ATIVA, unidadeNOVE.getStatus());
	}

	@Test
	public void parseVOToEntityTest() {
		Unidade unidade = DozerConverter.parseObject(mockUnidade.mockVO(), Unidade.class);
		Assert.assertEquals(Long.valueOf(0L), unidade.getId());
		Assert.assertEquals("CASCADURA0", unidade.getNome());
		Assert.assertEquals("RUA X 5000", unidade.getEndereco());
		Assert.assertEquals(Status.ATIVA, unidade.getStatus());
	}

	@Test
	public void parserVOListToEntityListTest() {
		List<Unidade> listaDeUnidades = DozerConverter.parseListObjects(mockUnidade.mockVOList(), Unidade.class);

		Unidade unidadeZERO = listaDeUnidades.get(0);

		Assert.assertEquals(Long.valueOf(0L), unidadeZERO.getId());
		Assert.assertEquals("CASCADURA0", unidadeZERO.getNome());
		Assert.assertEquals("RUA X 5000", unidadeZERO.getEndereco());
		Assert.assertEquals(Status.ATIVA, unidadeZERO.getStatus());

		Unidade unidadeSETE = listaDeUnidades.get(7);

		Assert.assertEquals(Long.valueOf(7L), unidadeSETE.getId());
		Assert.assertEquals("CASCADURA7", unidadeSETE.getNome());
		Assert.assertEquals("RUA X 5007", unidadeSETE.getEndereco());
		Assert.assertEquals(Status.ATIVA, unidadeSETE.getStatus());

		Unidade unidadeDOZE = listaDeUnidades.get(12);

		Assert.assertEquals(Long.valueOf(12L), unidadeDOZE.getId());
		Assert.assertEquals("CASCADURA12", unidadeDOZE.getNome());
		Assert.assertEquals("RUA X 50012", unidadeDOZE.getEndereco());
		Assert.assertEquals(Status.ATIVA, unidadeDOZE.getStatus());
	}
}
