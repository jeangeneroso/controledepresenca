package com.example.controledepresenca.service;

public class ReverService {
	
/*	    public Colaborador listarPorId(Integer id) {
    return repository.findById(id)
            .orElseThrow(() -> new ColaboradorNaoEncontradoException(id));
}


	public List<Colaborador> buscarPorNome(String nomeColaborador) {
// TODO Auto-generated method stub
return null;
}

@Autowired
	private ControleDePresencaRepository repository;
	@GetMapping("/despesas")
	public List<Despesa> getDespesas(){
		return repository.findAll();
		
	}
	
@Service
public class ColaboradorService {

    private final ColaboradorRepository repository;

    public ColaboradorService(ColaboradorRepository repository) {
        this.repository = repository;
    }

    // Listar todos
    public List<Colaborador> listarTodos() {
        return repository.findAll();
    }

    // Listar apenas um
    public Colaborador listarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
    }

    // Inclusão de um
    public Colaborador salvar(Colaborador colaborador) {
        if (colaborador.getNomeColaborador() == null || colaborador.getNomeColaborador().isBlank()) {
            throw new IllegalArgumentException("Nome do colaborador é obrigatório");
        }
        return repository.save(colaborador);
    }

    // Inclusão de todos (lista)
    public List<Colaborador> salvarTodos(List<Colaborador> colaboradores) {
        return repository.saveAll(colaboradores);
    }

    // Alteração de um
    public Colaborador atualizar(Integer id, Colaborador dadosAtualizados) {
        Colaborador colaborador = listarPorId(id);
        colaborador.setNomeColaborador(dadosAtualizados.getNomeColaborador());
        colaborador.setChavePix(dadosAtualizados.getChavePix());
        colaborador.setRodizio(dadosAtualizados.getRodizio());
        colaborador.setDataPresenca(dadosAtualizados.getDataPresenca());
        return repository.save(colaborador);
    }

    // Alteração de todos
    public List<Colaborador> atualizarTodos(List<Colaborador> colaboradores) {
        return repository.saveAll(colaboradores);
    }

    // Exclusão de um
    public void excluir(Integer id) {
        Colaborador colaborador = listarPorId(id);
        repository.delete(colaborador);
    }
}
*/
	

	/*public Operacao salvar(Integer id, Operacao dadosAtualizados) {
		// TODO Auto-generated method stub

		Operacao operacao = repository.findById(id)
				.orElseThrow(() -> new RuntimeException(" Operação não cadastrada "));
		operacao.setNomeOperacao(dadosAtualizados.getNomeOperacao());
		operacao.setNomeOperacao(dadosAtualizados.getNomeOperacao());
		return repository.save(operacao);

	}*/
	
    /*public List<RegistroDiaria> listarTodos() {
    return presencaRepository.findAll();
}

public List<RegistroDiaria> listarPorColaborador(Integer colaboradorId) {
    return presencaRepository.findByColaboradorId(colaboradorId);
}

public List<RegistroDiaria> listarPorLider(Integer liderId) {
    return presencaRepository.findByLiderId(liderId);
}
*/
	
	/*	private final PresencaRepository presencaRepository;

    public PresencaService(PresencaRepository presencaRepository) {
        this.presencaRepository = presencaRepository;
    }

	public List<Presenca> listarTodos() {
        return presencaRepository.findAll();
	}

    public List<Presenca> listarPorColaborador(Integer colaboradorId) {
        return presencaRepository.findByColaboradorId(colaboradorId);
    }

    public List<Presenca> listarPorLider(Integer liderId) {
        return presencaRepository.findByLiderId(liderId);
    }

	public Presenca incluirPresencaColaborador(Integer colaboradorId, Presenca presenca) {
	    Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
	            .orElseThrow(() -> new RuntimeException(" Colaborador não cadastrado "));

	    presenca.setColaborador(colaborador);
	    presenca.setDia(LocalDate.now()); 
	    return presencaRepository.save(presenca);
	}


	public Presenca incluirPresencaLider(Integer id, Presenca presenca) {
		  Lider lider = liderRepository.findById(liderId)
		            .orElseThrow(() -> new RuntimeException(" Lider não cadastrado "));

		    presenca.setLider(lider);
		    presenca.setDia(LocalDate.now()); 
		    return presencaRepository.save(presenca);
		// TODO Auto-generated method stub
		return null;
	}*/
	
    
	


}
