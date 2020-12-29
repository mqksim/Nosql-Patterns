package nosql.product;

import nosql.product.Memento.Caretaker;
import nosql.product.Observer.ObjectObservable;
import nosql.product.mongo.BrandM;
import nosql.product.mongo.CategoryM;
import nosql.product.mongo.CompanyM;
import nosql.product.mongo.ProductM;
import nosql.product.mongoRepository.BrandMongoRepository;
import nosql.product.mongoRepository.CategoryMongoRepository;
import nosql.product.mongoRepository.CompanyMongoRepository;
import nosql.product.mongoRepository.ProductMongoRepository;
import nosql.product.sql.Brand;
import nosql.product.sql.Category;
import nosql.product.sql.Company;
import nosql.product.sql.Product;
import nosql.product.sqlRepository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryMongoRepository categoryMongoRepository;
    @Autowired
    CompanyMongoRepository companyMongoRepository;
    @Autowired
    ProductMongoRepository productMongoRepository;
    @Autowired
    BrandMongoRepository brandMongoRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
    @Override
    public void run(String... args) throws InterruptedException {
       // sql();
      //  mongo();
      //  sql_mongo();
       // migration();
       // replication();
        //aggregation();
        // aggregationTime();

        /*System.out.println(new Brand.Builder("brand").yearFormation(2000).build().toString());
        Singleton.getInstance().addUsedFunction("Brand.build()");
        Singleton.getInstance().addUsedFunction("Brand.toString()");
        Singleton.getInstance().addUsedFunction("System.out.println()");
        System.out.println();
        System.out.println(Singleton.getInstance().getUsedFunctions());


        ObjectObservable objectObservable = new ObjectObservable();
        objectObservable.registerObserver(Singleton.getInstance());
        System.out.println(new Brand.Builder("brand").yearFormation(2000).build().toString());
        objectObservable.notifyObservers("Brand.build()");
        objectObservable.notifyObservers("Brand.toString()");
        objectObservable.notifyObservers("System.out.println()");
        System.out.println(Singleton.getInstance().getUsedFunctions());
        */
/*
        Caretaker caretaker = new Caretaker();
        Category category = new Category("телевизор","описание");
        Company company = new Company("Samsung Production","Korea");
        Brand brand = new Brand("Eco",2000);
        Product p = new Product("TV",10000.0,100,company,category,brand);
        caretaker.addMemento(p.saveState());
        p.setQuantity(90);
        caretaker.addMemento(p.saveState());
        p.setPrice(120000.0);
        caretaker.addMemento(p.saveState());
        p.setTittle("TV_large");
        caretaker.addMemento(p.saveState());
        p.restoreState(caretaker.getMemento(1));
        System.out.println(p.toString());

 */
        register("Maxim","login","password",Role.User);
        register("Maxim","login2","password2",Role.Admin);
        Role r1= logIn("login","password");
        Role r2= logIn("login2","password2");
        Product p = productRepository.findById((long)36).get();
        p.setPrice(10000.0);
        updateProduct(p,r1);
        updateProduct(p,r2);
        Category category = categoryRepository.findById((long)47).get();
        Company company = companyRepository.findById((long)146).get();
        Brand brand = brandRepository.findById((long)51).get();
        Product p2 = new Product("TV2",10000.0,100,company,category,brand);
        insertProduct(p2,r1);
        insertProduct(p2,r2);
        deleteProductById((long)46,r1);
        deleteProductById((long)46 ,r2);
    }


    public void sql() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        companyRepository.deleteAll();
        brandRepository.deleteAll();
        //insert
        Category category = new Category("телевизор","описание");
        categoryRepository.save(category);
        categoryRepository.save(new Category("чайник","описание"));
        categoryRepository.save(new Category("лампа","описание"));
        categoryRepository.save(new Category("стиральная машина","описание"));
        categoryRepository.save(new Category("телефон","описание"));

        Company company = new Company("Samsung Production","Korea");
        companyRepository.save(company);
        companyRepository.save(new Company("Samsung Production5","Korea"));
        companyRepository.save(new Company("Samsung Production4","Korea"));
        companyRepository.save(new Company("Samsung Production3","Korea"));
        companyRepository.save(new Company("Samsung Production2","Korea"));

        Brand brand = new Brand("Eco",2000);
        brandRepository.save(brand);
        brandRepository.save(new Brand("Hp",1990));
        brandRepository.save(new Brand("MicroWave",1989));
        brandRepository.save(new Brand("G-Cube",1950));
        brandRepository.save(new Brand("GreenWave",1966));

        Product p = new Product("TV",10000.0,100,company,category,brand);
        productRepository.save(p);
        productRepository.save(new Product("TV_small",1000.0,100,company,category,brand));
        //select by tittle
        for (Product product : productRepository.findAllByPriceBetween(1000.0,2000.0)) {
            System.out.println(product);
        }
        System.out.println();
        System.out.println();
        //update
        p.setQuantity(90);
        productRepository.save(p);
        //delete
        productRepository.deleteAllByTittle("TV_small");
        for (Product product : productRepository.findAll()) {
            System.out.println(product);
        }
        productRepository.save(new Product("Чайник 2л",1000.0,100,company,category,brand));
        productRepository.save(new Product("Чайник 3л",2000.0,100,company,category,brand));
        productRepository.save(new Product("Планшет Самсунг",9000.0,100,company,category,brand));
        productRepository.save(new Product("Микроволновка х25",6000.0,100,company,category,brand));
    }

    public void mongo() {
        categoryMongoRepository.deleteAll();
        brandMongoRepository.deleteAll();
        productMongoRepository.deleteAll();
        companyMongoRepository.deleteAll();
        //insert
        CategoryM category = new CategoryM("плазма","описание");
        categoryMongoRepository.save(category);
        categoryMongoRepository.save(new CategoryM("микроволновая печь","описание"));
        categoryMongoRepository.save(new CategoryM("холодильник","описание"));
        categoryMongoRepository.save(new CategoryM("ноутбук","описание"));
        categoryMongoRepository.save(new CategoryM("нетбук","описание"));

        BrandM brand = new BrandM("Samsung",2001);
        brandMongoRepository.save(brand);
        brandMongoRepository.save(new BrandM("Asus",1996));
        brandMongoRepository.save(new BrandM("Accer",1989));
        brandMongoRepository.save(new BrandM("Lenovo",1977));
        brandMongoRepository.save(new BrandM("Elenberg",2001));

        CompanyM company = new CompanyM("Asus Production2","Korea");
        companyMongoRepository.save(company);
        companyMongoRepository.save(new CompanyM("Accer Production2","China"));
        companyMongoRepository.save(new CompanyM("Lenovo Production2","China"));
        companyMongoRepository.save(new CompanyM("Elenberg Production2","Korea"));
        companyMongoRepository.save(new CompanyM("Hp Production2","Korea"));

        ProductM p = new ProductM("Ноутбук, Ideapad780",10000.0,100,company,category,brand);
        productMongoRepository.save(p);
        productMongoRepository.save(new ProductM("Ноутбук, Ideapad680",4000.0,200,company,category,brand));

        //select by tittle
        for (ProductM mobile : productMongoRepository.findAllByPriceBetween(1000.0,5000.0)) {
            System.out.println(mobile);
        }
        System.out.println();
        System.out.println();
        //update
        p.setQuantity(90);
        productMongoRepository.save(p);
        //delete
        productMongoRepository.deleteAllByTittle("Ноутбук, Ideapad680");
        for (ProductM productM : productMongoRepository.findAll()) {
            System.out.println(productM);
        }
        productMongoRepository.save(new ProductM("Ноутбук, Ideapad680",4000.0,200,company,category,brand));
        productMongoRepository.save(new ProductM("Ноутбук, Ideapad580",4000.0,200,company,category,brand));
        productMongoRepository.save(new ProductM("Ноутбук, Ideapad480",4000.0,200,company,category,brand));
        productMongoRepository.save(new ProductM("Ноутбук, Ideapad380",4000.0,200,company,category,brand));

    }

    public void sql_mongo() {
        productRepository.deleteAll();
        companyRepository.deleteAll();
        companyMongoRepository.deleteAll();
        Long startTime2 = System.nanoTime();
        for (Integer i = 1; i < 100; i++) {
            companyRepository.save(new Company("Asus Production"+i,"Korea"));
        }
        Long endTime2 = System.nanoTime();

        Long startTime = System.nanoTime();
        for (Integer i = 1; i < 100; i++) {
            companyMongoRepository.save(new CompanyM("Asus Production"+i,"Korea"));
        }
        Long endTime = System.nanoTime();
        System.out.print("Insert into SQL took:");
        System.out.println((endTime2 - startTime2) / (double) 1000000000);
        System.out.print("Insert into Mongo took:");
        System.out.println((endTime - startTime) / (double) 1000000000);

        startTime = System.nanoTime();
        List<Company> companyList = companyRepository.findAllByCompanyName("Asus Production2");
        endTime = System.nanoTime();
        System.out.print("Select from SQL took:");
        System.out.println((endTime - startTime) / (double) 1000000000);

        startTime = System.nanoTime();
        List<CompanyM> companyMList = companyMongoRepository.findAllByCompanyName("Asus Production2");
        endTime = System.nanoTime();
        System.out.print("Select from Mongo took:");
        System.out.println((endTime - startTime) / (double) 1000000000);
    }

    public void migration() {
        List<Category> categories = categoryRepository.findAll();
        for (Category c : categories) {
            if(categoryMongoRepository.findFirstByCategoryName(c.getCategoryName()).isEmpty())
                categoryMongoRepository.save(new CategoryM(c));
        }

        List<Company> companies = companyRepository.findAll();
        for (Company c : companies) {
            if(companyMongoRepository.findFirstByCompanyName(c.getCompanyName()).isEmpty())
                companyMongoRepository.save(new CompanyM(c));
        }

        List<Brand> brands = brandRepository.findAll();
        for (Brand b : brands) {
            if(brandMongoRepository.findFirstByBrandName(b.getBrandName()).isEmpty())
                brandMongoRepository.save(new BrandM(b));
        }

        List<Product> products = productRepository.findAll();
        for (Product p : products) {
            if(productMongoRepository.findFirstByTittle(p.getTittle()).isEmpty())
                productMongoRepository.save(new ProductM(p));
        }
//////////////////////////////////////////
        List<CategoryM> categoryMList = categoryMongoRepository.findAll();
        for (CategoryM c : categoryMList) {
            if(categoryRepository.findFirstByCategoryName(c.getCategoryName()).isEmpty())
                categoryRepository.save(new Category(c));
        }

        List<CompanyM> companyMList = companyMongoRepository.findAll();
        for (CompanyM c : companyMList) {
            if(companyRepository.findFirstByCompanyName(c.getCompanyName()).isEmpty())
                companyRepository.save(new Company(c));
        }

        List<BrandM> brandMList = brandMongoRepository.findAll();
        for (BrandM b : brandMList) {
            if(brandRepository.findFirstByBrandName(b.getBrandName()).isEmpty())
                brandRepository.save(new Brand(b));
        }

        List<ProductM> productMList = productMongoRepository.findAll();
        for (ProductM p : productMList) {
            Brand b;
            Company com;
            Category cat;
            if(brandRepository.findFirstByBrandName(p.getBrand().getBrandName()).isEmpty()) {
                b=new Brand(p.getBrand());
                brandRepository.save(b);
            }
            else{
                b=brandRepository.findFirstByBrandName(p.getBrand().getBrandName()).get();
            }
            if(companyRepository.findFirstByCompanyName(p.getCompany().getCompanyName()).isEmpty()) {
                com=new Company(p.getCompany());
                companyRepository.save(com);
            }
            else{
                com=companyRepository.findFirstByCompanyName(p.getCompany().getCompanyName()).get();
            }
            if(categoryRepository.findFirstByCategoryName(p.getCategory().getCategoryName()).isEmpty()) {
                cat=new Category(p.getCategory());
                categoryRepository.save(cat);
            }
            else{
                cat=categoryRepository.findFirstByCategoryName(p.getCategory().getCategoryName()).get();
            }
            if(productRepository.findFirstByTittle(p.getTittle()).isEmpty()) {
                productRepository.save(new Product(p,com,cat,b));
            }
        }
    }

    public void replication() throws InterruptedException {
        categoryMongoRepository.deleteAll();
        Long startTime = System.nanoTime();
        for (Integer i = 1; i < 100000; i++) {
            insert(new CategoryM("Категория" + i, "описание"));
        }
        Long endTime = System.nanoTime();

        System.out.print("Insert into Mongo took:");
        System.out.println((endTime - startTime) / (double) 1000000000);

        startTime = System.nanoTime();
        List<CategoryM> categoryList = categoryMongoRepository.findAll();
        endTime = System.nanoTime();
        System.out.print("Select from Mongo took:");
        System.out.println((endTime - startTime) / (double) 1000000000);

    }

    public boolean insert(CategoryM categoryM) throws InterruptedException {
        int tempts = 3;
        while (tempts > 0) {
            try {
                if (categoryMongoRepository.save(categoryM) != null) {
                    return true;
                }
            } catch (Exception e) {
                tempts--;
                Thread.sleep(1000);
            }
        }
        System.out.println("Error to insert document");
        return false;
    }


    public void aggregation() {
        //1Agg
        for (Result r : productMongoRepository.countProductInCategory()) {
            System.out.println(r);
        }
        //2Agg
        for (Result r : productMongoRepository.countProductInCompany()) {
            System.out.println(r);
        }
        //3 Agg
        for (Result r : productMongoRepository.maxPriceInBrand()) {
            System.out.println(r);
        }
        //4 Agg
        for (Result r : productMongoRepository.minPriceInCategory()) {
            System.out.println(r);
        }
        //5Agg
        for (ProductM p : productMongoRepository.matchPriceAndQuantity()) {
            System.out.println(p);
        }
        //
    }

    public void aggregationTime() {
        productMongoRepository.deleteAll();
        CategoryM category = new CategoryM("плазма","описание");
        BrandM brand = new BrandM("Samsung",2001);
        CompanyM company = new CompanyM("Asus Production2","Korea");
         for (Integer i = 1; i < 100000; i++) {
           productMongoRepository.save(new ProductM("Ноутбук, Ideapad780"+i,4000.0+i%50000,200+i%1000,company,category,brand));
 }

        long startTime = System.nanoTime();
        List<Result> result = productMongoRepository.countProductInCategory();
        long endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        startTime = System.nanoTime();
        List<ProductM> temp = productMongoRepository.findAll();
        HashMap<String, Integer> countCategory = new HashMap<>();
        for (ProductM p : temp) {
            Integer frequency = countCategory.get(p.getCategory().getCategoryName());
            countCategory.put(p.getCategory().getCategoryName(), frequency == null ? 1 : frequency + 1);
        }
        result = new ArrayList<Result>();
        for (Map.Entry<String, Integer> entry : countCategory.entrySet()) {
            result.add(new Result(entry.getKey(), entry.getValue()));
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        ///2 Agg
        startTime = System.nanoTime();
        result = productMongoRepository.countProductInCompany();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        startTime = System.nanoTime();
        temp = productMongoRepository.findAll();
        HashMap<String, Integer> countCompany = new HashMap<>();
        for (ProductM p : temp) {
            Integer frequency = countCompany.get(p.getCompany().getCompanyName());
            countCompany.put(p.getCompany().getCompanyName(), frequency == null ? 1 : frequency + 1);
        }
        result = new ArrayList<Result>();
        for (Map.Entry<String, Integer> entry : countCompany.entrySet()) {
            result.add(new Result(entry.getKey(), entry.getValue()));
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //3Agg
        startTime = System.nanoTime();
        result = productMongoRepository.maxPriceInBrand();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        startTime = System.nanoTime();
        temp = productMongoRepository.findAll();
        HashMap<String, Double> maxPriceBrand = new HashMap<>();
        for (ProductM p : temp) {
            Double maxp = maxPriceBrand.get(p.getBrand().getBrandName());
            maxPriceBrand.put(p.getBrand().getBrandName(), maxp == null ? p.getPrice() : maxp<p.getPrice()?p.getPrice():maxp);
        }
        result = new ArrayList<Result>();
        for (Map.Entry<String, Double> entry : maxPriceBrand.entrySet()) {
            result.add(new Result(entry.getKey(), entry.getValue()));
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //4Agg
        startTime = System.nanoTime();
        result = productMongoRepository.minPriceInCategory();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        temp = productMongoRepository.findAll();
        HashMap<String, Double> minPriceCategory = new HashMap<>();
        for (ProductM p : temp) {
            Double minp = minPriceCategory.get(p.getCategory().getCategoryName());
            minPriceCategory.put(p.getCategory().getCategoryName(), minp == null ? p.getPrice() : minp<p.getPrice()?p.getPrice():minp);
        }
        result = new ArrayList<Result>();
        for (Map.Entry<String, Double> entry : minPriceCategory.entrySet()) {
            result.add(new Result(entry.getKey(), entry.getValue()));
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //5Agg
        startTime = System.nanoTime();
        List<ProductM> list = productMongoRepository.matchPriceAndQuantity();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        startTime = System.nanoTime();
        temp = productMongoRepository.findAll();
        list = new ArrayList<>();
        for (ProductM tem : temp) {
            if (tem.getPrice() <10000 && tem.getQuantity()>9)
                list.add(tem);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);
    }

    public Role logIn(String login, String password){
        Optional<User> u=userRepository.findFirstByLoginAndPassword(login,password);
        if(u.isEmpty()){
            System.out.println("Not correct login or password");
            return null;
        }
        else{
            return u.get().getRole();
        }
    }
    public Boolean register(String name,String login, String password,Role role){
        Optional<User> u=userRepository.findFirstByLoginAndPassword(login,password);
        if(u.isEmpty()){
            userRepository.save(new User(name,login,password,role));
            return true;
        }
        else{
            return false;
        }
    }

    public void updateProduct(Product p,Role r){
        if(r==Role.Admin){
            productRepository.save(p);
        }
        else{
            System.out.println("Ошибка! Недостаточно прав для обновления!");
        }
    }
    public void deleteProductById(Long id,Role r){
        if(r==Role.Admin){
            productRepository.deleteById(id);
        }
        else{
            System.out.println("Ошибка! Недостаточно прав для удаления!");
        }
    }
    public void insertProduct(Product p,Role r){
        if(r==Role.Admin){
            productRepository.save(p);
        }
        else{
            System.out.println("Ошибка! Недостаточно прав для добавления!");
        }
    }
}
