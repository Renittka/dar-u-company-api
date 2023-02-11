package kz.dar.university.company.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "client-core-api")
public interface ClientClient {



}
