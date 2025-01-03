package com.echo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.echo.exception.CategoryNotFoundException;
import com.echo.exception.ProductNotFoundException;
import com.echo.models.CategoryEnum;
import com.echo.models.Product;
import com.echo.models.ProductDTO;
import com.echo.models.ProductStatus;
import com.echo.models.Seller;
import com.echo.repository.ProductDao;
import com.echo.repository.SellerDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao prodDao;

	@Autowired
	private SellerService sService;

	@Autowired
	private SellerDao sDao;

	@Override
	public Product addProductToCatalog(String token, Product product) {

		Product prod = null;
		Seller seller1 = sService.getCurrentlyLoggedInSeller(token);
		product.setSeller(seller1);

		Seller Existingseller = sService.getSellerByMobile(product.getSeller().getMobile(), token);
		Optional<Seller> opt = sDao.findById(Existingseller.getSellerId());

		if (opt.isPresent()) {
			Seller seller = opt.get();

			product.setSeller(seller);

			prod = prodDao.save(product);
			;

			seller.getProduct().add(product);
			sDao.save(seller);

		} else {
			prod = prodDao.save(product);
			;
		}

		return prod;
	}

	@Override
	public Product getProductFromCatalogById(Integer id) throws ProductNotFoundException {

		Optional<Product> opt = prodDao.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}

		else
			throw new ProductNotFoundException("Product not found with given id");
	}

	@Override
	public String deleteProductFromCatalog(Integer id) throws ProductNotFoundException {
		Optional<Product> opt = prodDao.findById(id);
		
		if (opt.isPresent()) {
			Product prod = opt.get();
			System.out.println(prod);
			prodDao.delete(prod);
			return "Product deleted from catalog";
		} else
			throw new ProductNotFoundException("Product not found with given id");

	}

	@Override
	public Product updateProductIncatalog(Product prod) throws ProductNotFoundException {

		Optional<Product> opt = prodDao.findById(prod.getProductId());

		if (opt.isPresent()) {
			opt.get();
			Product prod1 = prodDao.save(prod);
			return prod1;
		} else
			throw new ProductNotFoundException("Product not found with given id");
	}

	@Override
	public List<Product> getAllProductsIncatalog() {
		List<Product> list = prodDao.findAll();
		
		if (list.size() > 0) {
			return list;
		} else
			throw new ProductNotFoundException("No products in catalog");

	}

	@Override
	public List<ProductDTO> getProductsOfCategory(CategoryEnum catenum) {

		List<ProductDTO> list = prodDao.getAllProductsInACategory(catenum);
		if (list.size() > 0) {

			return list;
		} else
			throw new CategoryNotFoundException("No products found with category:" + catenum);
	}

	@Override
	public List<ProductDTO> getProductsOfStatus(ProductStatus status) {

		List<ProductDTO> list = prodDao.getProductsWithStatus(status);

		if (list.size() > 0) {
			return list;
		} else
			throw new ProductNotFoundException("No products found with given status:" + status);
	}

	@Override
	public Product updateProductQuantityWithId(Integer id,ProductDTO prodDto) {
		Product prod = null;
		 Optional<Product> opt = prodDao.findById(id);
		 
		 if(opt!=null) {
			  prod = opt.get();
			 prod.setQuantity(prod.getQuantity()+prodDto.getQuantity());
			 if(prod.getQuantity()>0) {
				 prod.setStatus(ProductStatus.AVAILABLE);
			 }
			 prodDao.save(prod);
			 
		 }
		 else
			 throw new ProductNotFoundException("No product found with this Id");
		
		return prod;
	}

	

	@Override
	public List<ProductDTO> getAllProductsOfSeller(Integer id) {
		
		List<ProductDTO> list = prodDao.getProductsOfASeller(id);
		
		if(list.size()>0) {
			
			return list;
			
		}
		
		else {
			throw new ProductNotFoundException("No products with SellerId: "+id);
		}
	}

}
