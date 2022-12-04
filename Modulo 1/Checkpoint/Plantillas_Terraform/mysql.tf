resource "docker_image" "mysql" {
  name = "mysql"
}

resource "docker_container" "mysql" {
  name  = "mysql"
  image = docker_image.mysql.image_id
  env = [
    "MYSQL_ROOT_PASSWORD=abcD_1234"
  ]
  ports {
    internal = 3306
    external = 3307
  }
  depends_on = [
    docker_image.mysql
  ]
}

output "ip" { value = "MYSQL_IP=${docker_container.mysql.ip_address}" }