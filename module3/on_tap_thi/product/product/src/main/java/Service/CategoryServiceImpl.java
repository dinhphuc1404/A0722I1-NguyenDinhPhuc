package Service;

import Model.Category;
import Repository.CategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository= new CategoryRepository();
    @Override
    public List<Category> getListCategory() {
        return  categoryRepository.getListCategory();
    }
}
