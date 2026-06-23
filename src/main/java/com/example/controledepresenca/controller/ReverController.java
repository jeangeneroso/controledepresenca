package com.example.controledepresenca.controller;

public class ReverController {
	
	 /*  @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarPorId(@PathVariable Integer id) {
        try {
            Colaborador colaborador = service.listarPorId(id);
            return ResponseEntity.ok(colaborador);
        } catch (ColaboradorNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
*/
       
   /* @GetMapping("/nome/{nome}")
    public List<Colaborador> buscarPorNome(@PathVariable String nomeColaborador) {
        return colaboradorService.buscarPorNome(nomeColaborador);
    }*/

    /*@PostMapping
    public Colaborador criar(@RequestBody Colaborador colaborador) {
        return colaboradorService.salvar(colaborador);
    }*/
	

    /*@PutMapping("/{id}")
    public Colaborador atualizar(@PathVariable Integer id, @RequestBody Colaborador colaborador) {
        return colaboradorService.atualizar(id, colaborador);
    }*/
	
	/*@RestController
	@RequestMapping("/colaboradores")
	public class ColaboradorController {

	    private final ColaboradorService colaboradorService;

	    public ColaboradorController(ColaboradorService colaboradorService) {
	        this.colaboradorService = colaboradorService;
	    }

	    // Listar todos
	    @GetMapping
	    public List<Colaborador> getTodos() {
	        return colaboradorService.listarTodos();
	    }

	    // Listar apenas um
	    @GetMapping("/{id}")
	    public Colaborador getPorId(@PathVariable Integer id) {
	        return colaboradorService.listarPorId(id);
	    }

	    // Inclusão de um
	    @PostMapping
	    public Colaborador criar(@RequestBody Colaborador colaborador) {
	        return colaboradorService.salvar(colaborador);
	    }

	    // Inclusão de todos
	    @PostMapping("/lista")
	    public List<Colaborador> criarLista(@RequestBody List<Colaborador> colaboradores) {
	        return colaboradorService.salvarTodos(colaboradores);
	    }

	    // Alteração de um
	    @PutMapping("/{id}")
	    public Colaborador atualizar(@PathVariable Integer id, @RequestBody Colaborador colaborador) {
	        return colaboradorService.atualizar(id, colaborador);
	    }

	    // Alteração de todos
	    @PutMapping("/lista")
	    public List<Colaborador> atualizarLista(@RequestBody List<Colaborador> colaboradores) {
	        return colaboradorService.atualizarTodos(colaboradores);
	    }

	    // Exclusão de um
	    @DeleteMapping("/{id}")
	    public void excluir(@PathVariable Integer id) {
	        colaboradorService.excluir(id);
	    }
	}
	*/


  /*  @RestController
    @RequestMapping("/api/diarias") // Já mapeado com o prefixo /api que seu proxy espera
    @CrossOrigin(origins = "*")
    public class DiariaRegistradaController {

        @Autowired
        private DiariaRegistradaRepository diariaRepository;

        // 1. MÉTODO PARA LISTAR TODAS AS DIÁRIAS
        @GetMapping
        public List<DiariaRegistrada> listarTodas() {
            return diariaRepository.findAll();
        }

        // 2. MÉTODO PARA SALVAR A DIÁRIA (Trata Líder e Colaborador)
        @PostMapping
        public ResponseEntity<DiariaRegistrada> salvar(@RequestBody DiariaRegistrada diaria) {

            // Lógica para definir a função dinamicamente antes de salvar no banco
            if (diaria.getLider() != null && diaria.getLider().getId() != null) {
                diaria.setFuncao("LIDER");
                diaria.setColaborador(null); // Garante que não salve lixo no campo oposto
            } else if (diaria.getColaborador() != null && diaria.getColaborador().getId() != null) {
                diaria.setFuncao("COLABORADOR");
                diaria.setLider(null); // Garante que não salve lixo no campo oposto
            } else {
                // Se não enviou nem líder nem colaborador, retorna erro de requisição ruim
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            // Salva no banco de dados e retorna o objeto salvo com o ID gerado
            DiariaRegistrada diariaSalva = diariaRepository.save(diaria);
            return ResponseEntity.status(HttpStatus.CREATED).body(diariaSalva);
        }
    }
*/
}
