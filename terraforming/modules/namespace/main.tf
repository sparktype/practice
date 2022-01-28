resource "kubernetes_namespace" "center" {
  metadata {
    name = "center"
  }
}

resource "kubernetes_namespace" "customer" {
  metadata {
    name = "customer"
  }
}

resource "kubernetes_config_map" "customer_config" {
  metadata {
    name = "config"
    namespace = kubernetes_namespace.customer.metadata[0].name
  }

  data = {
    "env" = "dev"
    "config-server" = "optional:configserver:http://config.center.svc.cluster.local:8888"
  }
}

resource "kubernetes_namespace" "database" {
  metadata {
    name = "database"
  }
}