variable "resource_group_location" {
  default     = "eastus"
  description = "Locación del grupo de recursos."
}

variable "resource_group_name_prefix" {
  default     = "rg"
  description = "Prefijo del nombre del grupo de recursos que se combina con un ID aleatorio para que el nombre sea único en su suscripción de Azure."
}