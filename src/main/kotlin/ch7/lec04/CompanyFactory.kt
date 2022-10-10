package ch7.lec04

class CompanyFactory {
    companion object {
        fun create(arr: Array<Any>): Company {
            assert(arr.size >= 2)

            val domainName = arr[0] as String
            val numberOfEmployees = arr[1] as Int

            return Company(domainName, numberOfEmployees)
        }

    }
}