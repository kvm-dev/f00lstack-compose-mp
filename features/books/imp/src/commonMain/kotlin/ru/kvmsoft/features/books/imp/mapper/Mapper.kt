package ru.kvmsoft.features.books.imp.mapper

import ru.kvmsoft.base.storage.model.Book
import ru.kvmsoft.base.storage.model.Books
import ru.kvmsoft.base.storage.model.ProfessionListItem
import ru.kvmsoft.base.ui.model.BookItem
import ru.kvmsoft.base.ui.model.BooksItemState
import ru.kvmsoft.base.ui.model.Chip
import ru.kvmsoft.base.ui.model.EventItem
import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.utils.timestampToDateString
import ru.kvmsoft.features.books.api.model.BookDomain
import ru.kvmsoft.features.books.api.model.BookProfessionDomain
import ru.kvmsoft.features.books.api.model.BooksDomain
import ru.kvmsoft.features.books.imp.model.BookResponse

object Mapper {

    fun map(response: BookResponse): BookDomain {
        val professions = ArrayList<BookProfessionDomain>()
        response.professions.forEach { profession->
            professions.add(BookProfessionDomain(
                professionId = profession.professionId,
                professionName = profession.professionName
            ))
        }
        return BookDomain(
            bookId = response.bookId,
            bookName = response.bookName,
            bookDescription = response.bookDescription,
            bookImageBase64 = response.bookImage,
            bookRefLink = response.bookRefLink,
            bookCostWithoutSale = response.bookCostWithoutSale,
            bookCostWithSale = response.bookCostWithSale,
            professions = professions
        )
    }

    fun map(response: Book):BookDomain{
        val professions = ArrayList<BookProfessionDomain>()
        response.professions.forEach {profession->
            professions.add(BookProfessionDomain(
                professionId = profession.professionId,
                professionName = profession.professionName
            ))
        }
        return BookDomain(
            bookId = response.bookId,
            bookName = response.bookName,
            bookDescription = response.bookDescription,
            bookImageBase64 = response.bookImageBase64,
            bookRefLink = response.bookRefLink,
            bookCostWithoutSale = response.bookCostWithoutSale,
            bookCostWithSale = response.bookCostWithSale,
            professions = professions
        )
    }

    fun map(response: BooksDomain): Books {
        val bookList = ArrayList<Book>()
        response.books.forEach { book->
            val professions = ArrayList<ProfessionListItem>()
            book.professions.forEach { profession->
                professions.add(ProfessionListItem(
                    professionId = profession.professionId,
                    professionName = profession.professionName
                ))
            }
            bookList.add(Book(
                bookId = book.bookId,
                bookName = book.bookName,
                bookDescription = book.bookDescription,
                bookImageBase64 = book.bookImageBase64,
                bookRefLink = book.bookRefLink,
                bookCostWithSale = book.bookCostWithSale,
                bookCostWithoutSale = book.bookCostWithoutSale,
                professions = professions
            ))
        }
        return Books(
            books = bookList,
            maxSalePercent = response.maxSalePercent,
            prText = response.prText,
            subscribeText = response.subscribeText,
            subscribeMinCost = response.subscribeMinCost,
            subscribeLink = response.subscribeLink,
            errorMsg = response.errorMsg
        )
    }

    fun mapToChips(booksState: UiState<BooksItemState>): List<Chip>{
        val list = HashSet<Chip>()
        if (booksState is UiState.Success){
                booksState.data?.books?.forEach { book->
                    book.bookTags.forEach { sub->
                        list.add(sub)
                    }
                }
        }
        return list.toList()
    }

    private fun mapToBookChip(sub: BookProfessionDomain): Chip {
        return Chip(
            id = sub.professionId,
            name = sub.professionName
        )
    }

    fun List<BookDomain>.mapToBooksItems(): List<BookItem>{
        val list = ArrayList<BookItem>()
        if(this.isNotEmpty()){
            this.forEach {  book->
                val tags = ArrayList<Chip>()
                book.professions.forEach { profession->
                    tags.add(Chip(id = profession.professionId, name = profession.professionName))
                }
                list.add(BookItem(
                    bookId = book.bookId,
                    bookName = book.bookName,
                    bookDescription = book.bookDescription,
                    bookPrice = book.bookCostWithoutSale,
                    bookSalePrice = book.bookCostWithSale,
                    bookImageBase64 = book.bookImageBase64,
                    bookTags = tags,
                    bookRefLink = book.bookRefLink
                ))
            }
        }
        return list
    }
}