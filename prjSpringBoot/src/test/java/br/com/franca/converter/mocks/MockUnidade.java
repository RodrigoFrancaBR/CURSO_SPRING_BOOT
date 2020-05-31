package br.com.franca.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.franca.domain.Unidade;
import br.com.franca.domain.enun.Status;
import br.com.franca.domain.vo.UnidadeVO;

public class MockUnidade {
	public Unidade mockEntity() {
		return mockEntity(0L);
	}

	private Unidade mockEntity(Long id) {
		return new Unidade(id, "CASCADURA" + id, "RUA X 500" + id, Status.ATIVA);
	}

	public UnidadeVO mockVO() {
		return mockVO(0L);
	}

	private UnidadeVO mockVO(Long id) {
		return new UnidadeVO(id, "CASCADURA" + id, "RUA X 500" + id, Status.ATIVA);
	}

	public List<Unidade> mockEntityList() {
		List<Unidade> listaDeUnidades = new ArrayList<Unidade>();
		for (Long i = 0L; i < 14; i++) {
			listaDeUnidades.add(mockEntity(i));
		}
		return listaDeUnidades;
	}

	public List<UnidadeVO> mockVOList() {
		List<UnidadeVO> listaDeUnidadesVO = new ArrayList<>();
		for (Long i = 0L; i < 14; i++) {
			listaDeUnidadesVO.add(mockVO(i));
		}
		return listaDeUnidadesVO;
	}
}
