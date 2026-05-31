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