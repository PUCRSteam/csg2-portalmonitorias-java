provider "aws" {
  region = "us-east-1"
}

resource "aws_instance" "CS-EC2" {
  ami           = "ami-0fc5d935ebf8bc3bc"
  instance_type = "t2.micro"
  key_name      = "key"
  subnet_id     = "subnet-06bf86b77aec87c14"
  vpc_security_group_ids = ["sg-083e1df904caa0df7"]

  private_ip            = "172.31.19.28"
  associate_public_ip_address = true

  tags = {
    Name = "grupo contrucao de software"
  }
}

resource "aws_volume_attachment" "grupoConstrucao" {
  instance_id          = aws_instance.example.id
  volume_id            = "vol-002b68136b862cd7b"
  device_name          = "/dev/sda1"
}

